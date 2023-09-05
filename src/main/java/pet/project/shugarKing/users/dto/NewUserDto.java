package pet.project.shugarKing.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewUserDto {

    @NotBlank
    @Size(min = 4, max = 50)
    private String nickName;

    @NotBlank
    @Size(min = 4, max = 25)
    private String firstName;

    @NotBlank
    @Size(min = 4, max = 25)
    private String lastName;

    @NotBlank
    @Email
    private String email;
}
