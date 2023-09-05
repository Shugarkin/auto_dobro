package pet.project.shugarKing.users.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private long id;

    private String nickName;

    private String firstName;

    private String lastName;
}
