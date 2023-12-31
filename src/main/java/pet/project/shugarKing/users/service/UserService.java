package pet.project.shugarKing.users.service;

import org.springframework.data.domain.Page;
import pet.project.shugarKing.users.model.User;
import pet.project.shugarKing.users.model.UserWithLikes;

import java.util.List;

public interface UserService {
    User createUsers(User user);

    Page<User> getUsers();

    void deleteUser(long userId);

    UserWithLikes getUserById(long userId);

    User putUserById(long userId, User user);
}
