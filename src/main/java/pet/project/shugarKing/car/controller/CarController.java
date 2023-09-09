package pet.project.shugarKing.car.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pet.project.shugarKing.car.dto.CarDto;
import pet.project.shugarKing.car.dto.NewCarDto;
import pet.project.shugarKing.car.mapper.CarMapper;
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
    public CarDto postCar(@PathVariable long userId, @RequestBody NewCarDto car) {
        Car newCar = service.postCar(userId, CarMapper.toCar(car));
        return CarMapper.toCarDto(newCar);
    }

    @GetMapping("/cars")
    public List<CarDto> getCarsFromUserId(@PathVariable long userId) {
        List<Car> list = service.getCarsFromUserId(userId);
        return CarMapper.toListCarDto(list);
    }

    @GetMapping("/cars/{carNumber}")
    public CarDto getCarById(@PathVariable long userId, @PathVariable String carNumber) {
        Car car = service.getCarById(userId, carNumber);
        return CarMapper.toCarDto(car);
    }

    @DeleteMapping("/cars/{carNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable long userId, @PathVariable String carNumber) {
        service.deleteCar(userId, carNumber);
    }
}
