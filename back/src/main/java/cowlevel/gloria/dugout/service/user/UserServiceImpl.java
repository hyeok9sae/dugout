package cowlevel.gloria.dugout.service.user;

import cowlevel.gloria.dugout.config.security.JwtTokenProvider;
import cowlevel.gloria.dugout.dto.user.User;
import cowlevel.gloria.dugout.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    // 파일이 저장되는 경로
    private static final String imagePath = "C:/Users/jaehyeokk/Desktop/dugout/back/src/main/webapp/";
    // 프론트에 반환할 경로
    private static final String returnPath = "src/main/webapp/";
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public List<User> findAllUsers() {
        return mapper.selectAllUsers();
    }

    @Override
    public User findUserById(Long id) {
        return mapper.selectUserById(id);
    }

    @Override
    public boolean addUser(User user, MultipartFile file) throws IOException {
        // password 암호화
        encodingPassword(user);
        // file upload
        // email 별로 파일을 저장하기 위해 email이름을 가진 폴더 생성
        File f = new File(imagePath+user.getEmail());
        // 파일이 존재할 경우 email별 폴더에 저장 및 경로저장(프론트에 반환할 경로 별도)
        // 파일이 존재 하지 않을 경우 null 저장)
        if(file != null){
            f.mkdirs();
            String originalFileName = file.getOriginalFilename();
            File dest = new File(imagePath + user.getEmail() + "/" + originalFileName);
            file.transferTo(dest);
            user.setPhoto(returnPath + user.getEmail() + "/n" + originalFileName);
        } else{
            user.setPhoto(null);
        }
        return mapper.insertUser(user);
    }

    @Override
    public boolean modifyUser(User user, MultipartFile file) throws IOException {
        // password 암호화
        encodingPassword(user);
        // file upload
        // email 별로 파일을 저장하기 위해 email이름을 가진 폴더 생성
        User u = mapper.selectUserById(user.getId());
        File f = new File(imagePath+u.getEmail());
        // email폴더가 이미 존재할경우 파일 누적을 방지하기 위해
        // 폴더 및 하위 파일들 삭제
        while (f.exists()){
            File[] f_list = f.listFiles();
            for (int i = 0; i < f_list.length; i++){
                f_list[i].delete();
            }
            if (f_list.length == 0 && f.isDirectory()){
                f.delete();
            }
        }
        // 파일이 존재할 경우 email별 폴더에 저장 및 경로저장(프론트에 반환할 경로 별도)
        // 파일이 존재 하지 않을 경우 null 저장)
        if(file != null){
            f.mkdirs();
            String originalFileName = file.getOriginalFilename();
            File dest = new File(imagePath + u.getEmail() + "/" + originalFileName);
            file.transferTo(dest);
            user.setPhoto(returnPath + u.getEmail() + "/n" + originalFileName);
        } else{
            user.setPhoto(null);
        }
        return mapper.updateUser(user);
    }

    @Override
    public boolean removeUserById(Long id) {
        User u = mapper.selectUserById(id);
        File f = new File(imagePath+u.getEmail());
        // email폴더가 이미 존재할경우 파일 누적을 방지하기 위해
        // 폴더 및 하위 파일들 삭제
        while (f.exists()){
            File[] f_list = f.listFiles();
            for (int i = 0; i < f_list.length; i++){
                f_list[i].delete();
            }
            if (f_list.length == 0 && f.isDirectory()){
                f.delete();
            }
        }
        return mapper.deleteUserById(id);
    }

    @Override
    public String login(User user) {
        User u = mapper.selectUserByEmail(user.getEmail());
        if (user.getEmail() == null){
            return null;
        }
        // 입력되어 암호화된 패스워드와 기존에 저장된 암호화된 패스워드를 비교
        boolean check = passwordEncoder.matches(user.getPassword(), u.getPassword());
        if (check){
            return jwtTokenProvider.createToken(user.getEmail());
        }
        return null;
    }

    public void encodingPassword(User user){
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
    }
}
