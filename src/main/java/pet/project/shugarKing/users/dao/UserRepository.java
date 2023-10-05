package pet.project.shugarKing.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.project.shugarKing.users.model.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
