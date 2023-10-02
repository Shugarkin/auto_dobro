package pet.project.shugarKing.malfunctions.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pet.project.shugarKing.car.model.Car;
import pet.project.shugarKing.malfunctions.type.AllMalfunction;
import pet.project.shugarKing.malfunctions.type.MalfunctionType;
import pet.project.shugarKing.users.model.User;

import java.time.LocalDateTime;
import java.util.List;

//неисправности машины

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@Table(name = "malfunctions")
public class Malfunctions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    //тип неисправности
    @Column(name = "type_malfunctions")
    @Enumerated(EnumType.STRING)
    private MalfunctionType type;

    //дата
    @Column(name = "create_on")
    private LocalDateTime createOn;

    //что именно сломалось
    @Column(name = "malfunctions")
    @Enumerated(EnumType.STRING)
    private AllMalfunction malfunction;

    //машина у которой поломка
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "helper")
    private User helper;


    public Malfunctions(long id, MalfunctionType type, LocalDateTime createOn, AllMalfunction malfunction, Car car, User helper) {
        this.id = id;
        this.type = type;
        this.createOn = createOn;
        this.malfunction = malfunction;
        this.car = car;
        this.helper = helper;
    }
}
