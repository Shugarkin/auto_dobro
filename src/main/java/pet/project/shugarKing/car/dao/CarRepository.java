package pet.project.shugarKing.car.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.project.shugarKing.car.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByUserId(long userId);

    Optional<Car> findByCarNumberAndCarRegion(String carNumber, int carRegion);

    void deleteByCarNumberAndCarRegion(String carNumber, int carRegion);

    boolean existsByCarNumberAndCarRegion(String carNumber, int carRegion);
}
