package pet.project.shugarKing.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pet.project.shugarKing.users.model.User;
import pet.project.shugarKing.users.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        User newUser = service.createUsers(user);
        return newUser;
    }

    @GetMapping("users")
    public List<User> getUsers() {
        List<User> list = service.getUsers();
        return list;
    }
}
