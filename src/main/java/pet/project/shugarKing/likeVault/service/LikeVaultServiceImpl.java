package pet.project.shugarKing.likeVault.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pet.project.shugarKing.exceptions.ConflictException;
import pet.project.shugarKing.exceptions.NotFoundException;
import pet.project.shugarKing.likeVault.dao.LikeVaultRepository;
import pet.project.shugarKing.likeVault.model.Like;
import pet.project.shugarKing.malfunctions.dao.MalfunctionRepository;
import pet.project.shugarKing.malfunctions.model.Malfunctions;
import pet.project.shugarKing.users.dao.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikeVaultServiceImpl implements LikeVaultService {

    private final LikeVaultRepository repository;

    private final UserRepository userRepository;

    private final MalfunctionRepository malfunctionRepository;


    @Transactional
    @Override
    public Like createLike(long liker, long malId) {

        //валидация на один лайк одномк человеку и от одного. exist()

        Like like = check(liker, malId);

        return repository.save(like);
    }

    @Transactional
    @Override
    public String deleteLike(long liker, long malId) {

        Like like =  check(liker, malId);
        //не нравится этп реализация. надо поменять
        repository.deleteByLikerIdAndLikeOwnerId(like.getLiker().getId(), like.getLikeOwner().getId());
        return "Лайк удален";
    }

    @Override
    public Like getLike(long liker, long likeId) {
        return repository.findById(likeId).get();
    }


    private Like check(long liker, long malId) {
        Malfunctions malfunctions = malfunctionRepository.findById(malId).orElseThrow(() -> new NotFoundException("Неисправность не найдена."));

        if (liker != malfunctions.getCar().getUser().getId()) throw new ConflictException("Вы не можете лайкать то, чтовам не приходило.");

        return Like.builder()
                .liker(malfunctions.getCar().getUser())
                .likeOwner(malfunctions.getHelper()).build();
    }
}
