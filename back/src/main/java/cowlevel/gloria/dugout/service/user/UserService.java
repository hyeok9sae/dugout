package cowlevel.gloria.dugout.service.user;

import cowlevel.gloria.dugout.dto.user.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    public List<User> findAllUsers();
    public User findUserById(Long id);
    public boolean addUser(User user, MultipartFile file) throws IOException;
    public boolean modifyUser(User user, MultipartFile file) throws IOException;
    public boolean removeUserById(Long id);
    public User login(User user);
}
