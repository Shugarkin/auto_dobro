package pet.project.shugarKing.car.mapper;

import lombok.experimental.UtilityClass;
import pet.project.shugarKing.car.dto.CarDto;
import pet.project.shugarKing.car.dto.NewCarDto;
import pet.project.shugarKing.car.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CarMapper {

    public Car toCar(NewCarDto carDto) {
        return Car.builder()
                .carNumber(carDto.getCarNumber())
                .carRegion(carDto.getCarRegion())
                .build();
    }

    public CarDto toCarDto(Car car) {
        return CarDto.builder()
                .carNumber(car.getCarNumber())
                .carRegion(car.getCarRegion())

                .build();
    }

    public List<CarDto> toListCarDto(List<Car> list) {
        return list.stream().map(CarMapper::toCarDto).collect(Collectors.toList());
    }
}
