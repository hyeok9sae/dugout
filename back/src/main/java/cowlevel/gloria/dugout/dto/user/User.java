package cowlevel.gloria.dugout.dto.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class User {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String photo;
    private String stateComment;
    private int isAdmin;
}
