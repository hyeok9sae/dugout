package cowlevel.gloria.dugout.repository.user;

import cowlevel.gloria.dugout.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 이메일(아이디)로 조회
    Optional<User> findByEmail(String email);
}
