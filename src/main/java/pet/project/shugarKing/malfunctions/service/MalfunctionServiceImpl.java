package pet.project.shugarKing.malfunctions.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pet.project.shugarKing.blackList.service.BlackListService;
import pet.project.shugarKing.car.dao.CarRepository;
import pet.project.shugarKing.car.dto.NewCarDto;
import pet.project.shugarKing.car.model.Car;
import pet.project.shugarKing.exceptions.ConflictException;
import pet.project.shugarKing.exceptions.NotFoundException;
import pet.project.shugarKing.malfunctions.dao.MalfunctionRepository;
import pet.project.shugarKing.malfunctions.model.Malfunctions;
import pet.project.shugarKing.users.dao.UserRepository;
import pet.project.shugarKing.users.model.User;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MalfunctionServiceImpl implements MalfunctionService {

    private final MalfunctionRepository repository;

    private final CarRepository carRepository;

    private final UserRepository userRepository;

    private final BlackListService blackListService;

    @Transactional
    @Override
    public Malfunctions createMalfunction(long userId, NewCarDto carNumber, Malfunctions malfunction) {
        Car car = carRepository.findByCarNumberAndCarRegion(carNumber.getCarNumber().toLowerCase(), carNumber.getCarRegion())
                .orElseThrow(() -> new NotFoundException("Транспорта с таким номером нет"));

        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("Вы или не сущесвуете в БД"));

        if (car.getUser().getId() == userId) throw new ConflictException("Вы отправляете запрос о неисправности сами себе");

        malfunction.setCreateOn(LocalDateTime.now());
        malfunction.setCar(car);
        malfunction.setHelper(user);

        boolean check = blackListService.check(malfunction.getCar().getUser().getId(), malfunction.getHelper().getId());
        if(check) return malfunction;

        return check(malfunction);
    }

    @Override
    public Malfunctions getMalfunction(long userId, long malId) {
        Malfunctions malfunctions = repository.findById(malId)
                .orElseThrow(() -> new NotFoundException("Неисправность не найдена"));

        if (malfunctions.getCar().getUser().getId() != userId)
            throw new ConflictException("Вы не можете просматривать чужие неисправности");

        return malfunctions;
    }

    @Override
    public List<Malfunctions> getAllMalfunction(long userId) {

        Pageable parameter = PageRequest.of(0, 10, Sort.by("createOn").ascending());

        List<Malfunctions> malfunctionsList = repository.findAllByCarUserId(userId, parameter);

        return malfunctionsList;
    }

    @Transactional
    @Override
    public String deleteMalfunction(long userId, long malId) {
        Malfunctions mal = repository.findById(malId).orElseThrow(() -> new NotFoundException("Неисправность не найдена"));
        if (mal.getCar().getUser().getId() != userId)
            throw new ConflictException("Вы не можете удалять чужие неисправности");

        repository.delete(mal);
        return "Неисправность с id = " + malId + " удалена.";
    }

    @Transactional
    @Override
    public String deleteAllMalfunctions(long userId) {
        repository.deleteAllByCarUserId(userId);
        return "Все неисправности пользователя с id = " + userId + " удаленны.";
    }

    //проверка на однотипные сообщения и защита от закликивания
    private Malfunctions check(Malfunctions malfunctions) {
        Malfunctions answer = repository.existsUser(malfunctions.getHelper());
        //если этот пользователь сегодня уже отправлял эту ошибку, то в базу ее не сохраняем
        if (answer == null) {
            int count = repository.existsAnswer(malfunctions.getType().name(), malfunctions.getCar().getCarNumber(), malfunctions.getCar().getCarRegion());
            //если такого рода ошибок в день уже было 3, то так же в бд не сохраняем
            if (count == 3) {
                return malfunctions;
            } else {
                return repository.save(malfunctions);
            }
        } else {
            return malfunctions;
        }
    }
}
