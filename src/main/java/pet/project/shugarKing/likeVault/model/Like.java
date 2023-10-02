package pet.project.shugarKing.likeVault.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pet.project.shugarKing.users.model.User;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@Table(name = "like_vault")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "liker")
    private User liker;

    @ManyToOne
    @JoinColumn(name = "like_Owner")
    private User likeOwner;

    public Like(long id, User liker, User likeOwner) {
        this.id = id;
        this.liker = liker;
        this.likeOwner = likeOwner;
    }
}
