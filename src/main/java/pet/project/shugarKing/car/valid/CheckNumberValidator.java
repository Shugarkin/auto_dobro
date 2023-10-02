package pet.project.shugarKing.car.valid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pet.project.shugarKing.car.dto.NewCarDto;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckNumberValidator implements ConstraintValidator<CarNumberValidAnnotation, NewCarDto> {

    // лист с номерами регионов существующих на территории РФ за исключением первых 99
    private List<Integer> regionList = List.of(101, 102, 113, 116, 121, 123, 124, 125, 126, 134, 136, 138, 142, 150, 152, 154, 159, 161, 163, 164, 173, 174, 177,
            178, 186, 190, 196, 197, 199, 716, 750, 777, 799, 977);

    @Override
    public void initialize(CarNumberValidAnnotation constraintAnnotation) {
    }

    @Override
    public boolean isValid(NewCarDto newCarDto, ConstraintValidatorContext constraintValidatorContext) {
        String carNumber = newCarDto.getCarNumber();
        int carRegion = newCarDto.getCarRegion();
        if (carNumber == null || carRegion == 0) return false;

        // Pattern patternNumber = Pattern.compile("^[АВЕКМНОРСТУХABEKMHOPCTYX]{1}\\d{3}[АВЕКМНОРСТУХABEKMHOPCTYX]{2}$"); латинский и кириллица
         Pattern patternNumber = Pattern.compile("^[АВЕКМНОРСТУХавекмнорстух]{1}\\d{3}[АВЕКМНОРСТУХавекмнорстух]{2}$");
        Matcher matcherNumber = patternNumber.matcher(carNumber);
        if (!matcherNumber.matches()) return false;
        return (carRegion > 0 && carRegion < 100 && carRegion != 20) || regionList.contains(carRegion);
    }
}
