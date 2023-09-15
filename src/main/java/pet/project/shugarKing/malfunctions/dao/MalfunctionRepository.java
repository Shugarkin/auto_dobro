package pet.project.shugarKing.malfunctions.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.project.shugarKing.malfunctions.model.Malfunctions;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MalfunctionRepository extends JpaRepository<Malfunctions, Long> {
    List<Malfunctions> findAllByCarUserId(long userId, Pageable parameter);

    void deleteAllByCarUserId(long userId);
}
