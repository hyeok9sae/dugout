package cowlevel.gloria.dugout.dto.user;

import cowlevel.gloria.dugout.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateRequestDto {
    private String nickname;
    private String photo;
    private String stateComment;
}
