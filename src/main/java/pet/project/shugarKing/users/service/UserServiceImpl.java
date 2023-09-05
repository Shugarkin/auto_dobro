package pet.project.shugarKing.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pet.project.shugarKing.exceptions.NotFoundException;
import pet.project.shugarKing.users.dao.UserRepository;
import pet.project.shugarKing.users.model.User;

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
    public User getUserById(long userId) {
        return repository.findById(userId).orElseThrow(() -> new NotFoundException("Пользователь для удаления не найден."));
    }

    @Transactional
    @Override
    public User putUserById(long userId, User user) {
        User userOld = repository.findById(userId).orElseThrow(() -> new NotFoundException("Пользователь для удаления не найден."));
        if (user.getFirstName() != null) userOld.setFirstName(user.getFirstName());
        if (user.getLastName() != null) userOld.setLastName(user.getLastName());
        if (user.getEmail() != null) userOld.setEmail(user.getEmail());
        if (user.getNickName() != null) userOld.setNickName(user.getNickName());
        return userOld;
    }

}
