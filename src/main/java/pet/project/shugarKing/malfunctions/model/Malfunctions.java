package pet.project.shugarKing.malfunctions.model;

import jakarta.persistence.*;
import lombok.*;
import pet.project.shugarKing.car.model.Car;
import pet.project.shugarKing.malfunctions.type.AllMalfunction;
import pet.project.shugarKing.malfunctions.type.MalfunctionType;
import pet.project.shugarKing.users.model.User;

import java.time.LocalDateTime;

//неисправности машины

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
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

}
