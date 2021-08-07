package cowlevel.gloria.dugout.entity.user;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {

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

    @PrePersist
    public void setIsAdmin() {
        this.isAdmin = 0;
    }

    @Builder
    public User(String email, String password, String nickname, String photo, String stateComment, int isAdmin) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.photo = photo;
        this.stateComment = stateComment;
        this.isAdmin = isAdmin;
    }

    // 무분별한 setter 사용금지 -> 객체에서 메소드로 정의하여 변경하면 변경의도를 한번에 파악할 수 있고 객체 지향 관점에도 부합
    public void update(String nickname, String stateComment){ // 정보 변경
        this.nickname = nickname;
        this.stateComment = stateComment;
    }

    public void updatePassword(String password){ // 비밀번호 변경
        this.password = password;
    }

    public void updateProfileImage(String photo){ // 프로필 이미지 변경
        this.photo = photo;
    }

    // UserDetails Override
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



}
