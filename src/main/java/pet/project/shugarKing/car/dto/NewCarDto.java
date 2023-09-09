package pet.project.shugarKing.car.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewCarDto {


    //написать аннотацию для валидации номера

    private String carNumber;

    private int carRegion;
}
