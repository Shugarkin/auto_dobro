package pet.project.shugarKing.car.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pet.project.shugarKing.car.dao.CarRepository;
import pet.project.shugarKing.car.model.Car;
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
        checkUser(userId, car);
        return repository.save(car);
    }

    @Override
    public List<Car> getCarsFromUserId(long userId) {
        List<Car> list = repository.findAllByUserId(userId);
        return list;
    }


    private void checkUser(long userId, Car car) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь для добавления машины не найден"));
        car.setUser(user);
    }
}
