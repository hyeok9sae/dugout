package cowlevel.gloria.dugout.dto.user;

import cowlevel.gloria.dugout.entity.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class UserSaveRequestDto {

    private String email;
    @Setter
    private String password;
    private String nickname;
    @Setter
    @ApiModelProperty(hidden = true)
    private String photo;
    private String stateComment;

    public User toEntity(){
        return User.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .photo(photo)
                .stateComment(stateComment)
                .build();
    }
}
