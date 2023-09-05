package pet.project.shugarKing.car.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.project.shugarKing.car.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
