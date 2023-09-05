package pet.project.shugarKing.car.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.project.shugarKing.car.model.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByUserId(long userId);
}
