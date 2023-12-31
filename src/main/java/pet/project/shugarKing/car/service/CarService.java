package pet.project.shugarKing.car.service;

import pet.project.shugarKing.car.model.Car;

import java.util.List;

public interface CarService {
    Car postCar(long userId, Car car);

    List<Car> getCarsFromUserId(long userId);

    Car getCarById(long userId, String carNumber);

    void deleteCar(long userId, String carNumber);
}
