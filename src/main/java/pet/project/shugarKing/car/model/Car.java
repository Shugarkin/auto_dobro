package pet.project.shugarKing.car.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pet.project.shugarKing.malfunctions.model.Malfunctions;
import pet.project.shugarKing.users.model.User;


@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
public class Car {

    @Id
    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "car_region")
    private int carRegion;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Car(String carNumber, int carRegion, User user) {
        this.carNumber = carNumber;
        this.carRegion = carRegion;
        this.user = user;
    }

    //список неисправностей контретной машины
    //private Malfunctions listMalfunctions;
}
