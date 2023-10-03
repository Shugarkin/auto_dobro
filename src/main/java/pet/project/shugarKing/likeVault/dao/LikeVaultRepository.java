package pet.project.shugarKing.likeVault.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.project.shugarKing.likeVault.model.Like;

public interface LikeVaultRepository extends JpaRepository<Like, Long> {
    void deleteByLikerIdAndLikeOwnerId(long id, long id1);
}
