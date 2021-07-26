package cowlevel.gloria.dugout.service.user;

import cowlevel.gloria.dugout.dto.user.UserResponseDto;
import cowlevel.gloria.dugout.dto.user.UserSaveRequestDto;
import cowlevel.gloria.dugout.dto.user.UserUpdatePasswordRequestDto;
import cowlevel.gloria.dugout.dto.user.UserUpdateRequestDto;
import cowlevel.gloria.dugout.entity.user.User;
import cowlevel.gloria.dugout.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final String imagePath = "C:/Users/jaehyeokk/Desktop/dugout/backend/src/main/webapp/";
    private final UserRepository userRepository;

    @Transactional  // user 목록 조회
    public List<UserResponseDto> findAll(){
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional  // user 상세 조회
    public UserResponseDto findById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 유저가 존재하지 않습니다."));
        return new UserResponseDto(user);
    }

    @Transactional  // user 정보 등록(회원가입)
    public Long save(UserSaveRequestDto userSaveRequestDto, MultipartFile file) throws IOException {
        File folder = new File(imagePath + userSaveRequestDto.getEmail());
        folder.mkdirs();
        if (file != null) {
            String originalFileName = file.getOriginalFilename();
            String filePath = imagePath + userSaveRequestDto.getEmail() + "/" + originalFileName;
            File dest = new File(filePath);
            file.transferTo(dest);
            userSaveRequestDto.setPhoto(filePath);
        } else {
            BufferedImage image;
            File imageFile = new File("C:/Users/jaehyeokk/Desktop/standard_profile.png");
            image = ImageIO.read(imageFile);
            ImageIO.write(image, "png", new File(imagePath + userSaveRequestDto.getEmail() + "/" + "standard_profile.png"));
            userSaveRequestDto.setPhoto(imagePath + "standard_profile.png");
        }
        return userRepository.save(userSaveRequestDto.toEntity())
                .getId();
    }

    @Transactional // user 정보 수정
    public Long update(Long id, UserUpdateRequestDto userUpdateRequestDto) throws IOException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 유저가 존재하지 않습니다."));
        user.update(userUpdateRequestDto.getNickname(), userUpdateRequestDto.getStateComment());
        return id;
    }

    @Transactional // user 비밀번호 수정
    public Long updatePassword(Long id, UserUpdatePasswordRequestDto userUpdatePasswordRequestDto){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 유저가 존재하지 않습니다."));
        user.updatePassword(userUpdatePasswordRequestDto.getPassword());
        return id;
    }

    @Transactional
    public Long updateProfileImage(Long id, MultipartFile file) throws IOException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 유저가 존재하지 않습니다."));
        if (file != null){
            File folder = new File(imagePath + user.getEmail());
            deleteFolder(folder);
            folder.mkdirs();
            String originalFileName = file.getOriginalFilename();
            String filePath = imagePath + user.getEmail() + "/" + originalFileName;
            File dest = new File(filePath);
            file.transferTo(dest);
            user.updateProfileImage(filePath);
        }
        return id;
    }
    @Transactional  // user 정보 삭제
    public Long delete(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 유저가 존재하지 않습니다."));
        File folder = new File(imagePath + user.getEmail()); // 유저 정보 삭제시 프로필 사진 저장 폴더 삭제
        deleteFolder(folder);
        userRepository.delete(user);
        return id;
    }

    public void deleteFolder(File folder){
        while (folder.exists()){
            File[] f_list = folder.listFiles();
            for (int i = 0; i < f_list.length; i++){
                f_list[i].delete();
            }
            if (f_list.length == 0 && folder.isDirectory()){
                folder.delete();
            }
        }
    }
}
