package pet.project.shugarKing.blackList.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.project.shugarKing.blackList.model.BlackList;

import java.util.List;
import java.util.Optional;

public interface BlackListRepository extends JpaRepository<BlackList, Long> {
    boolean existsByUserIdAndBookedId(long userId, long bookedId);

    Optional<BlackList> findByUserIdAndBookedId(long userId, long bookedId);

    List<BlackList> findAllByUserId(long userId);
}
