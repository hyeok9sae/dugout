package cowlevel.gloria.dugout.repository.user;

import cowlevel.gloria.dugout.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
