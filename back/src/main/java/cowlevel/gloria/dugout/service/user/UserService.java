package cowlevel.gloria.dugout.service.user;

import cowlevel.gloria.dugout.dto.user.User;

import java.util.List;

public interface UserService {
    public List<User> findAllUsers();
    public User findUserById(Long id);
    public boolean addUser(User user);
    public boolean modifyUser(User user);
    public boolean removeUserById(Long id);
}
