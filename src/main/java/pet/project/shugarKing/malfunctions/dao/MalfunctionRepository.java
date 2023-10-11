package pet.project.shugarKing.malfunctions.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pet.project.shugarKing.malfunctions.model.Malfunctions;
import org.springframework.data.domain.Pageable;
import pet.project.shugarKing.users.model.User;

import java.util.List;

public interface MalfunctionRepository extends JpaRepository<Malfunctions, Long> {
    List<Malfunctions> findAllByCarUserId(long userId, Pageable parameter);

    void deleteAllByCarUserId(long userId);


    @Query(value = "select count(*) " +
            "from malfunctions m  " +
            "join cars c on c.id = m.car_id  " +
            "where m.create_on > (localtimestamp - 1 )  " +
            "and m.type_malfunctions = ?  " +
            "and c.car_number = ?  " +
            "and c.car_region = ? " +
            "limit 3 ", nativeQuery = true )
    int existsAnswer(String type, String carNumber, int carRegion);


    @Query(value = "select mal " +
            "from Malfunctions mal " +
            "where mal.createOn > (current_timestamp() - 1) " +
            "and mal.helper = ?1 ")
    Malfunctions existsUser(User helperId);
}
