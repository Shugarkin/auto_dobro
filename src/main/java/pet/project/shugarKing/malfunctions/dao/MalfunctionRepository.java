package pet.project.shugarKing.malfunctions.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pet.project.shugarKing.malfunctions.model.Malfunctions;
import org.springframework.data.domain.Pageable;
import pet.project.shugarKing.malfunctions.type.MalfunctionType;

import java.util.List;

public interface MalfunctionRepository extends JpaRepository<Malfunctions, Long> {
    List<Malfunctions> findAllByCarUserId(long userId, Pageable parameter);

    void deleteAllByCarUserId(long userId);

    @Query("select mal " +
            "from Malfunctions mal " +
            "where mal.createOn > (current_timestamp() - 1) " +
            "and mal.type = ?1 " +
            "and mal.car.carNumber = ?2 " +
            "and mal.car.carRegion = ?3 " )
    List<Malfunctions> existsAnswer(MalfunctionType type, String carNumber, int carRegion);

    @Query("select mal " +
            "from Malfunctions mal " +
            "where mal.createOn > (current_timestamp() - 1) " +
            "and mal.helperId = ?1 ")
    Malfunctions existsUser(long helperId);
}
