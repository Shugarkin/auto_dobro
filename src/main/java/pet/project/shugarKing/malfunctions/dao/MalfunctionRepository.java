package pet.project.shugarKing.malfunctions.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.project.shugarKing.malfunctions.model.Malfunctions;

import java.util.List;

public interface MalfunctionRepository extends JpaRepository<Malfunctions, Long> {
    List<Malfunctions> findAllByCarUserId(long userId);
}
