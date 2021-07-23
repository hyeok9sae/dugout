package cowlevel.gloria.dugout.entity.user;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String nickname;

    private String photo;

    @Column(name = "state_comment")
    private String stateComment;

    @NotNull
    @Column(name = "is_admin")
    private int isAdmin;

    @Builder
    public User(String email, String password, String nickname, String photo, String stateComment, int isAdmin) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.photo = photo;
        this.stateComment = stateComment;
        this.isAdmin = isAdmin;
    }

    public void update(String nickname, String photo, String stateComment){
        this.nickname = nickname;
        this.photo = photo;
        this.stateComment = stateComment;
    }

    public void updatePassword(String password){
        this.password = password;
    }
}
