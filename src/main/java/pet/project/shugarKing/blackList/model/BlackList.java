package pet.project.shugarKing.blackList.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "black_list")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BlackList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "booked_id")
    private long bookedId;

}
