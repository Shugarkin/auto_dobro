package pet.project.shugarKing.car.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pet.project.shugarKing.car.model.Car;
import pet.project.shugarKing.car.service.CarService;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("users/{userId}")
public class CarController {

    private final CarService service;

    @PostMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public Car postCar(@PathVariable long userId, @RequestBody Car car) {
        Car newCar = service.postCar(userId, car);
        return newCar;
    }

    @GetMapping("/cars")
    public List<Car> getCarsFromUserId(@PathVariable long userId) {
        List<Car> list = service.getCarsFromUserId(userId);
        return list;
    }
}
