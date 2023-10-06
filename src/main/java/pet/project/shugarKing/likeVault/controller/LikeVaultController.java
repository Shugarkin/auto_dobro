package pet.project.shugarKing.likeVault.controller;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pet.project.shugarKing.likeVault.dto.LikeDto;
import pet.project.shugarKing.likeVault.mapper.LikeMapper;
import pet.project.shugarKing.likeVault.model.Like;
import pet.project.shugarKing.likeVault.service.LikeVaultService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/users/{userId}/like")
public class LikeVaultController {

    private final LikeVaultService service;

    @PostMapping("/{malId}")
    public LikeDto createLike(@PathVariable(name = "userId") @Positive long liker, @PathVariable @Positive long malId) {
        return LikeMapper.toLikeDto(service.createLike(liker, malId));
    }

    @DeleteMapping("/{malId}")
    public String deleteLike(@PathVariable(name = "userId") @Positive long liker, @PathVariable @Positive long malId) {
        return service.deleteLike(liker, malId);
    }

    @GetMapping("/{likeId}")
    public LikeDto getLike(@PathVariable(name = "userId") @Positive long liker, @PathVariable @Positive long likeId) {
        return LikeMapper.toLikeDto(service.getLike(liker, likeId));
    }

    @GetMapping()
    public List<LikeDto> getAllLikes(@PathVariable @Positive long userId) {
        return LikeMapper.toListLike(service.getAllLikes(userId));
    }
}
