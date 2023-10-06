package pet.project.shugarKing.blockMalfunction.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import pet.project.shugarKing.malfunctions.type.AllMalfunction;

@Data
@Builder
public class NewBlockMalfunction {

    @Positive
    private long userId;

    @NotBlank
    private AllMalfunction malfunction;
}
