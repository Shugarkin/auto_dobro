package pet.project.shugarKing.likeVault.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LikeDto {

    private long id;

    private long liker;

    private long likeOwner;
}
