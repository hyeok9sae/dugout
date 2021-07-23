package cowlevel.gloria.dugout.dto.user;

import cowlevel.gloria.dugout.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
public class UserSaveRequestDto {

    private String email;
    private String password;
    private String nickname;
    private String photo;
    private String stateComment;
    private int isAdmin;

    public User toEntity(){
        return User.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .photo(photo)
                .stateComment(stateComment)
                .isAdmin(isAdmin)
                .build();
    }
}
