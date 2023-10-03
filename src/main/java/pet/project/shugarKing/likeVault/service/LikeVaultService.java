package pet.project.shugarKing.likeVault.service;

import pet.project.shugarKing.likeVault.model.Like;

public interface LikeVaultService {
    Like createLike(long liker, long malId);

    String deleteLike(long liker, long malId);

    Like getLike(long liker, long likeId);
}
