package pet.project.shugarKing.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pet.project.shugarKing.users.model.User;
import pet.project.shugarKing.users.model.UserWithLikes;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select new pet.project.shugarKing.users.model.UserWithLikes(u.id, u.nickName, u.firstName, u.lastName, u.email, count(l.likeOwner.id)) " +
            "from User as u join Like as l on u.id=l.likeOwner.id " +
            "where u.id=?1 and l.likeOwner.id=?1 ")
    Optional<UserWithLikes> findUserwithLikes(long userId);
}
