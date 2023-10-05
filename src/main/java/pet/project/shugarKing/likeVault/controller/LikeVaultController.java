package pet.project.shugarKing.likeVault.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
    public Like createLike(@PathVariable(name = "userId") long liker, @PathVariable long malId) {
        Like like = service.createLike(liker, malId);
        return like;
    }

    @DeleteMapping("/{malId}")
    public String deleteLike(@PathVariable(name = "userId") long liker, @PathVariable long malId) {
        return service.deleteLike(liker, malId);
    }

    @GetMapping("/{likeId}")
    public Like getLike(@PathVariable(name = "userId") long liker, @PathVariable long likeId) {
        return service.getLike(liker, likeId);
    }

    @GetMapping()
    public List<Like> getAllLikes(@PathVariable long userId) {
        return service.getAllLikes(userId);
    }
}
