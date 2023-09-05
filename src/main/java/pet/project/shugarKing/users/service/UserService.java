package pet.project.shugarKing.users.service;

import pet.project.shugarKing.users.model.User;

import java.util.List;

public interface UserService {
    User createUsers(User user);

    List<User> getUsers();
}
