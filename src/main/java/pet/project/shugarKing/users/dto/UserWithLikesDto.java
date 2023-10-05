package pet.project.shugarKing.users.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserWithLikesDto {

    private long id;

    private String nickName;

    private String firstName ;

    private String lastName;

    private String email;

    private List<Long> likes;
}
