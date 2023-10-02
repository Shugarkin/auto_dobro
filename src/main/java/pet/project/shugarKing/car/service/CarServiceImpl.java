package pet.project.shugarKing.car.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pet.project.shugarKing.car.dao.CarRepository;
import pet.project.shugarKing.car.model.Car;
import pet.project.shugarKing.exceptions.ConflictException;
import pet.project.shugarKing.exceptions.NotFoundException;
import pet.project.shugarKing.users.dao.UserRepository;
import pet.project.shugarKing.users.model.User;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository repository;

    private final UserRepository userRepository;


    @Transactional
    @Override
    public Car postCar(long userId, Car car) {
        check(userId, car);
        return repository.save(car);
    }

    @Override
    public List<Car> getCarsFromUserId(long userId) {
        if (!userRepository.existsById(userId)) throw new ConflictException("Пользователь не найден");
        List<Car> list = repository.findAllByUserId(userId);
        return list;
    }

    @Override
    public Car getCarById(long userId, String carNumberFull) {
        return getCar(userId, carNumberFull);
    }

    @Transactional
    @Override
    public void deleteCar(long userId, String carNumberFull) {
        repository.delete(getCar(userId, carNumberFull));
    }


    private void check(long userId, Car car) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь для добавления машины не найден"));

        if (repository.existsByCarNumberAndCarRegion(car.getCarNumber(), car.getCarRegion()))
            throw new ConflictException("Такой транспорт уже существует. ");
        car.setCarNumber(car.getCarNumber().toLowerCase());
        car.setUser(user);
    }


    private Car getCar(long userId, String carNumberFull) {
        String carNumber = carNumberFull.substring(0, 6).toLowerCase();
        int carRegion = Integer.parseInt(carNumberFull.substring(6));
        Car car = repository.findByCarNumberAndCarRegion(carNumber, carRegion)
                .orElseThrow(() -> new NotFoundException("Транспорт не найден"));

        if (car.getUser().getId() != userId) throw new ConflictException("Вы не владелец этого транспорта");

        return car;
    }
}
