package pet.project.shugarKing.car.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import pet.project.shugarKing.car.valid.CarNumberValidAnnotation;

@Data
@Builder
@CarNumberValidAnnotation
public class NewCarDto {

    @NotBlank
    private String carNumber;

    @NotNull
    private int carRegion;
}
