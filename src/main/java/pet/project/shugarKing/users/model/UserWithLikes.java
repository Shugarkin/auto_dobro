package pet.project.shugarKing.users.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserWithLikes {

    private long id;

    private String nickName;

    private String firstName ;

    private String lastName;

    private String email;

    private long likes;

}
