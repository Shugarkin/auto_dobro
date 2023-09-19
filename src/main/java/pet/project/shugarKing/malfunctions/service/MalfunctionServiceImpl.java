package pet.project.shugarKing.malfunctions.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pet.project.shugarKing.car.dao.CarRepository;
import pet.project.shugarKing.car.model.Car;
import pet.project.shugarKing.exceptions.ConflictException;
import pet.project.shugarKing.exceptions.NotFoundException;
import pet.project.shugarKing.malfunctions.dao.MalfunctionRepository;
import pet.project.shugarKing.malfunctions.dto.CarNumber;
import pet.project.shugarKing.malfunctions.model.Malfunctions;
import pet.project.shugarKing.users.dao.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MalfunctionServiceImpl implements MalfunctionService {

    private final MalfunctionRepository repository;

    private final CarRepository carRepository;

    private final UserRepository userRepository;

    @Transactional
    @Override
    public Malfunctions createMalfunction(long userId, CarNumber carNumber, Malfunctions malfunction) {
        Car car = carRepository.findByCarNumberAndCarRegion(carNumber.getCarNumber(), carNumber.getCarRegion())
                .orElseThrow(() -> new NotFoundException("Транспорта с таким номером нет"));

        if (!userRepository.existsById(userId) || car.getUser().getId() == userId)
            throw new ConflictException("Вы или не сущесвуете в БД или отправляете запрос о неисправности сами себе");

        malfunction.setCreateOn(LocalDateTime.now());
        malfunction.setCar(car);
        malfunction.setHelperId(userId);

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
        Malfunctions answer = repository.existsUser(malfunctions.getHelperId());
        //если этот пользователь сегодня уже отправлял эту ошибку, то в базу ее не сохраняем
        if (answer == null) {
            List<Malfunctions> malfunctionsList = repository.existsAnswer(malfunctions.getType().name(), malfunctions.getCar().getCarNumber(), malfunctions.getCar().getCarRegion());
            //если такого рода ошибок в день уже было 3, то так же в бд не сохраняем
            if (malfunctionsList.size() >= 3) {
                return malfunctions;
            } else {
                return repository.save(malfunctions);
            }
        } else {
            return malfunctions;
        }
    }
}
