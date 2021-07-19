package cowlevel.gloria.dugout.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
//@Component
@Getter
@Setter
public class User {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String photo;
    private String stateComment;
    private int isAdmin;
}
