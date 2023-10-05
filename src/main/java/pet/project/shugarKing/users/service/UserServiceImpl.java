package pet.project.shugarKing.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pet.project.shugarKing.exceptions.NotFoundException;
import pet.project.shugarKing.users.dao.UserRepository;
import pet.project.shugarKing.users.model.User;
import pet.project.shugarKing.users.model.UserWithLikes;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Transactional
    @Override
    public User createUsers(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> getUsers() {

        return repository.findAll();
    }

    @Transactional
    @Override
    public void deleteUser(long userId) {
        repository.deleteById(userId);
    }

    @Override
    public UserWithLikes getUserById(long userId) {
        UserWithLikes userWithLikes = repository.findUserwithLikes(userId).orElseThrow(() -> new NotFoundException("Пользователь для удаления не найден."));
        return userWithLikes;
    }

    //изменить email нельзя
    @Transactional
    @Override
    public User putUserById(long userId, User user) {
        User userOld = repository.findById(userId).orElseThrow(() -> new NotFoundException("Пользователь для удаления не найден."));
        if (user.getFirstName() != null && !user.getFirstName().isBlank()) userOld.setFirstName(user.getFirstName());
        if (user.getLastName() != null && !user.getLastName().isBlank()) userOld.setLastName(user.getLastName());
        if (user.getNickName() != null && !user.getNickName().isBlank()) userOld.setNickName(user.getNickName());
        return userOld;
    }

}
