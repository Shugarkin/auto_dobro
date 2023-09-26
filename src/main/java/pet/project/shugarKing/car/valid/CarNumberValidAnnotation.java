package pet.project.shugarKing.car.valid;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.TYPE_USE)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = CheckNumberValidator.class)
public @interface CarNumberValidAnnotation {

    String message() default "Не правильный номер транспорта";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
