package pet.project.shugarKing.blockMalfunction.model;

import jakarta.persistence.*;
import lombok.*;
import pet.project.shugarKing.malfunctions.type.AllMalfunction;
import pet.project.shugarKing.users.model.User;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "block_malfunctions")
public class BlockMalfunction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "block_malfunction")
    private AllMalfunction malfunction;
}
