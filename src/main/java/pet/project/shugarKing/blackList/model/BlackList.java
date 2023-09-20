package pet.project.shugarKing.blackList.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "black_list")
@Getter
@Setter
@NoArgsConstructor
@Builder
public class BlackList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "booked_id")
    private long bookedId;

    public BlackList(long id, long userId, long bookedId) {
        this.id = id;
        this.userId = userId;
        this.bookedId = bookedId;
    }
}
