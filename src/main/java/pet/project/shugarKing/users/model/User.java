package pet.project.shugarKing.users.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nick_Name")
    private String nickName;

    //имя пользователя
    @Column(name = "first_Name")
    private String firstName ;

    @Column(name = "last_Name")
    private String lastName;


    public User(long id, String nickName, String firstName, String lastName) {
        this.id = id;
        this.nickName = nickName;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
