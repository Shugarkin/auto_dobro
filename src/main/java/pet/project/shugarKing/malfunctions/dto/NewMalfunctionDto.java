package pet.project.shugarKing.malfunctions.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewMalfunctionDto {

    private CarNumber carNumber;

    private NewMalfunction mal;
}
