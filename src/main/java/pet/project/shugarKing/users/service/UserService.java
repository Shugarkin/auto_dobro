package pet.project.shugarKing.users.service;

import pet.project.shugarKing.users.model.User;

import java.util.List;

public interface UserService {
    User createUsers(User user);

    List<User> getUsers();

    void deleteUser(long userId);

    User getUserById(long userId);

    User putUserById(long userId, User user);
}
