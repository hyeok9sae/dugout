package cowlevel.gloria.dugout.service.user;

import cowlevel.gloria.dugout.dto.user.User;
import cowlevel.gloria.dugout.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserMapper mapper;

    @Override
    public List<User> findAllUsers() {
        return mapper.selectAllUsers();
    }

    @Override
    public User findUserById(Long id) {
        return mapper.selectUserById(id);
    }

    @Override
    public boolean addUser(User user) {
        return mapper.insertUser(user);
    }

    @Override
    public boolean modifyUser(User user) {
        return mapper.updateUser(user);
    }

    @Override
    public boolean removeUserById(Long id) {
        return mapper.deleteUserById(id);
    }
}
