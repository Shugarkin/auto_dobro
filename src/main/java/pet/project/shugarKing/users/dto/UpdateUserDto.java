package pet.project.shugarKing.users.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUserDto {

    private String nickName;

    private String firstName;

    private String lastName;

}
