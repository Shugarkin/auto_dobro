package pet.project.shugarKing.malfunctions.dto;

import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Data;
import pet.project.shugarKing.car.dto.NewCarDto;

@Data
@Builder
public class NewMalfunctionDto {

    @Valid
    private NewCarDto carNumber;

    private NewMalfunction mal;
}
