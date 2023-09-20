package pet.project.shugarKing.blackList.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pet.project.shugarKing.blackList.dao.BlackListRepository;
import pet.project.shugarKing.blackList.model.BlackList;
import pet.project.shugarKing.exceptions.ConflictException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BlackListServiceImpl implements BlackListService {

    private final BlackListRepository repository;

    @Transactional
    @Override
    public BlackList createBlock(BlackList blackList) {
        boolean answer = check(blackList.getUserId(), blackList.getBookedId());

        if (answer) throw new ConflictException("Вы уже заблокировли данного пользователя ранее");

        return repository.save(blackList);
    }

    @Override
    public boolean check(long userId, long bookedId) {
        return repository.existsByUserIdAndBookedId(userId, bookedId);
    }

    @Transactional
    @Override
    public String deleteBlock(long userId, long bookedId) {
        BlackList block = repository.findByUserIdAndBookedId(userId, bookedId).orElseThrow(() -> new ConflictException("Вы не добавляли данного пользователя в ЧС"));
        repository.delete(block);
        return "Пользователь с id = " + bookedId + " успешно удален из вашего ЧС";
    }

    @Override
    public List<BlackList> getList(long userId) {
        List<BlackList> allById = repository.findAllByUserId(userId);
        return allById;
    }
}
