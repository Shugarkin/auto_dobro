package pet.project.shugarKing.users.mapper;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import pet.project.shugarKing.users.dto.NewUserDto;
import pet.project.shugarKing.users.dto.UpdateUserDto;
import pet.project.shugarKing.users.dto.UserDto;
import pet.project.shugarKing.users.dto.UserWithLikesDto;
import pet.project.shugarKing.users.model.User;
import pet.project.shugarKing.users.model.UserWithLikes;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class UserMapper {

    public UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .nickName(user.getNickName())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public List<UserDto> toListUserDto(Page<User> list) {
        return list.stream().map(UserMapper::toUserDto).collect(Collectors.toList());
    }

    public User toUser(NewUserDto newUserDto) {
        return User.builder()
                .email(newUserDto.getEmail())
                .firstName(newUserDto.getFirstName())
                .lastName(newUserDto.getLastName())
                .nickName(newUserDto.getNickName())
                .build();
    }

    public User toUser(UpdateUserDto newUserDto) {
        return User.builder()
                .firstName(newUserDto.getFirstName())
                .lastName(newUserDto.getLastName())
                .nickName(newUserDto.getNickName())
                .build();
    }

    public UserWithLikesDto toUserWithLikesDto(UserWithLikes user) {
        return UserWithLikesDto.builder()
                .likes(user.getLikes())
                .nickName(user.getNickName())
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
