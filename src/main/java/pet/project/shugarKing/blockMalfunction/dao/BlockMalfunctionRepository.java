package pet.project.shugarKing.blockMalfunction.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pet.project.shugarKing.blockMalfunction.model.BlockMalfunction;
import pet.project.shugarKing.malfunctions.type.AllMalfunction;

import java.util.List;

public interface BlockMalfunctionRepository extends JpaRepository<BlockMalfunction, Long> {
    boolean existsByUserIdAndMalfunction(long userId, AllMalfunction malfunction);

    List<BlockMalfunction> findByUserId(long userId, Pageable page);
}
