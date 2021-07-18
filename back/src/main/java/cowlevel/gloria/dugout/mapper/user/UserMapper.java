package cowlevel.gloria.dugout.mapper.user;

import cowlevel.gloria.dugout.dto.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> selectAllUsers();
    public User selectUserById(Long id);
    public boolean insertUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUserById(Long id);
}
