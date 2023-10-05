package pet.project.shugarKing.users.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pet.project.shugarKing.users.dto.NewUserDto;
import pet.project.shugarKing.users.dto.UpdateUserDto;
import pet.project.shugarKing.users.dto.UserDto;
import pet.project.shugarKing.users.mapper.UserMapper;
import pet.project.shugarKing.users.model.User;
import pet.project.shugarKing.users.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody @Valid NewUserDto user) {
        User newUser = service.createUsers(UserMapper.toUser(user));
        return UserMapper.toUserDto(newUser);
    }

    @GetMapping
    public List<UserDto> getUsers() {
        List<User> list = service.getUsers();
        return UserMapper.toListUserDto(list);
    }


    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable @Positive long userId) {
        service.deleteUser(userId);
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable @Positive long userId) {
        User user = service.getUserById(userId);
        return UserMapper.toUserDto(user);
    }

    @PutMapping("/{userId}")
    public UserDto putUserById(@PathVariable @Positive long userId, @RequestBody UpdateUserDto user) {
        User newUser = service.putUserById(userId, UserMapper.toUser(user));
        return UserMapper.toUserDto(newUser);
    }
}
