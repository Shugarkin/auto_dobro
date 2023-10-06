package pet.project.shugarKing.likeVault.mapper;

import lombok.experimental.UtilityClass;
import pet.project.shugarKing.likeVault.dto.LikeDto;
import pet.project.shugarKing.likeVault.model.Like;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class LikeMapper {
    public LikeDto toLikeDto(Like like) {
        return LikeDto.builder()
                .likeOwner(like.getLikeOwner().getId())
                .liker(like.getLiker().getId())
                .build();
    }

    public List<LikeDto> toListLike(List<Like> allLikes) {
        return allLikes.stream().map(LikeMapper::toLikeDto).collect(Collectors.toList());
    }
}
