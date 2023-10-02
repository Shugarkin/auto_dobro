package pet.project.shugarKing.likeVault.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.project.shugarKing.likeVault.model.Like;
import pet.project.shugarKing.likeVault.service.LikeVaultService;

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
}
