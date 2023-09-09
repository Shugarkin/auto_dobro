package pet.project.shugarKing.car.dto;

import lombok.Builder;
import lombok.Data;
import pet.project.shugarKing.malfunctions.model.Malfunctions;

import java.util.List;

@Data
@Builder
public class CarDto {

    private String carNumber;

    private int carRegion;

    //private List<Malfunctions> malfunctions;
}
