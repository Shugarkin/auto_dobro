package pet.project.shugarKing.blockMalfunction.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pet.project.shugarKing.blockMalfunction.dto.NewBlockMalfunction;
import pet.project.shugarKing.blockMalfunction.mapper.BlockMalfunctionMapper;
import pet.project.shugarKing.blockMalfunction.model.BlockMalfunction;
import pet.project.shugarKing.blockMalfunction.service.BlockMalfunctionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("users/blockMal")
public class BlockMalfunctionController {

    private final BlockMalfunctionService service;

    @PostMapping
    public BlockMalfunction createBlockMalfunction(@RequestBody NewBlockMalfunction malfunction) {
        BlockMalfunction blockMalfunction = service.createBlockMalfunction(malfunction);
        return blockMalfunction;
    }

    @DeleteMapping("/{blockMalId}")
    public String deleteBlockMalfunction(@PathVariable long blockMalId) {
        return service.deleteBlockMalfinction(blockMalId);
    }

    @GetMapping("/{userId}")
    public List<BlockMalfunction> getAllBlockMalfunction(@PathVariable long userId) {
        List<BlockMalfunction> blockMalfunction = service.getAllBlockMalfunction(userId);
        return blockMalfunction;
    }
}
