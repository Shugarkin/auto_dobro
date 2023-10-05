package pet.project.shugarKing.likeVault.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.project.shugarKing.likeVault.model.Like;
import pet.project.shugarKing.users.model.User;

import java.util.List;

public interface LikeVaultRepository extends JpaRepository<Like, Long> {
    void deleteByLikerIdAndLikeOwnerId(long id, long id1);

    boolean existsByLikerIdAndLikeOwnerId(long liker, long likeOwner);

    List<Like> findAllByLikeOwnerId(long userId);

    long countByLikeOwnerId(long likeOwner);
}
