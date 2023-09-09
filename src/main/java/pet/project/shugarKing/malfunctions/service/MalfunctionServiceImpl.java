package pet.project.shugarKing.malfunctions.service;

import lombok.RequiredArgsConstructor;
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

        //надо добавить:
        //ограничение на количество добавляемых несправностей одного типа в день(что бы не надоедать 1001 сообщением)
        //функциональность запрещающую отправлять неисправности указанные пользователем(он и так знает что сломано и не надо доставать)


        malfunction.setCreateOn(LocalDateTime.now());
        malfunction.setCar(car);
        malfunction.setHelperId(userId);
        return repository.save(malfunction);
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

        //добавить сортировку по времени

        List<Malfunctions> list = repository.findAllByCarUserId(userId);

        return list;
    }
}
