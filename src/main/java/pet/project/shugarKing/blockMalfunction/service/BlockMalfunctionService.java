package pet.project.shugarKing.blockMalfunction.service;

import pet.project.shugarKing.blockMalfunction.dto.NewBlockMalfunction;
import pet.project.shugarKing.blockMalfunction.model.BlockMalfunction;

import java.util.List;

public interface BlockMalfunctionService {
    BlockMalfunction createBlockMalfunction(NewBlockMalfunction malfunction);

    String deleteBlockMalfinction(long blockMalId);

    List<BlockMalfunction> getAllBlockMalfunction(long userId);
}
