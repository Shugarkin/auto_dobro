package pet.project.shugarKing.blockMalfunction.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pet.project.shugarKing.blockMalfunction.dao.BlockMalfunctionRepository;
import pet.project.shugarKing.blockMalfunction.dto.NewBlockMalfunction;
import pet.project.shugarKing.blockMalfunction.model.BlockMalfunction;
import pet.project.shugarKing.exceptions.NotFoundException;
import pet.project.shugarKing.users.dao.UserRepository;
import pet.project.shugarKing.users.model.User;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BlockMalfunctionImpl implements BlockMalfunctionService {

    private final BlockMalfunctionRepository repository;

    private final UserRepository userRepository;

    @Override
    public BlockMalfunction createBlockMalfunction(NewBlockMalfunction malfunction) {
        User user = userRepository.findById(malfunction.getUserId()).orElseThrow(() -> new NotFoundException("Вы не можете сделать блок на неисправность так как вас нет в БД"));

        BlockMalfunction blockMalfunction = BlockMalfunction.builder()
                .malfunction(malfunction.getMalfunction())
                .user(user)
                .build();
        if (repository.existsByUserIdAndMalfunction(malfunction.getUserId(), malfunction.getMalfunction())) return blockMalfunction;
        return repository.save(blockMalfunction);
    }

    @Override
    public String deleteBlockMalfinction(long blockMalId) {
        repository.deleteById(blockMalId);
        return "Блокировка удалена";
    }

    @Override
    public List<BlockMalfunction> getAllBlockMalfunction(long userId) {
        Pageable page = PageRequest.of(0, 10);
        List<BlockMalfunction> list = repository.findByUserId(userId, page);
        return list;
    }
}
