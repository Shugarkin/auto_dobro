package pet.project.shugarKing.car.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewCarDto {


    //написать аннотацию для валидации номера

    @NotBlank
    private String carNumber;

    @NotNull
    private int carRegion;
}