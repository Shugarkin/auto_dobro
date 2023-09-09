package pet.project.shugarKing.car.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pet.project.shugarKing.malfunctions.model.Malfunctions;
import pet.project.shugarKing.users.model.User;


@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "car_region")
    private int carRegion;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Car(long id, String carNumber, int carRegion, User user) {
        this.id = id;
        this.carNumber = carNumber;
        this.carRegion = carRegion;
        this.user = user;
    }


    //список неисправностей контретной машины
    //private Malfunctions listMalfunctions;
}
