package cowlevel.gloria.dugout.service.user;

import cowlevel.gloria.dugout.config.security.JwtTokenProvider;
import cowlevel.gloria.dugout.dto.user.*;
import cowlevel.gloria.dugout.entity.user.User;
import cowlevel.gloria.dugout.repository.user.UserRepository;
import io.swagger.annotations.ApiImplicitParam;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional  // user 목록 조회
    public List<UserResponseDto> findAll(){
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional  // user 상세 조회
    public UserResponseDto findById(Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        User user = userRepository.findByEmail(authentication.getName())
//        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 유저가 존재하지 않습니다."));
        return new UserResponseDto(user);
    }

    @Transactional  // user 정보 등록(회원가입)
    public Long save(UserSaveRequestDto userSaveRequestDto, MultipartFile file) throws IOException {
        File folder = new File(imagePath + userSaveRequestDto.getEmail());
        folder.mkdirs();
        if (file != null) { // 사진을 등록했을 경우
            String originalFileName = file.getOriginalFilename();
            String filePath = imagePath + userSaveRequestDto.getEmail() + "/" + originalFileName;
            File dest = new File(filePath);
            file.transferTo(dest);
            userSaveRequestDto.setPhoto(filePath);
        } else { // 사진을 등록하지 않았을 경우 기본 이미지로 저장
            BufferedImage image;
            File imageFile = new File("C:/Users/jaehyeokk/Desktop/profile.png");
            image = ImageIO.read(imageFile);
            ImageIO.write(image, "png", new File(imagePath + userSaveRequestDto.getEmail() + "/" + "profile.png"));
            userSaveRequestDto.setPhoto(imagePath + "standard_profile.png");
        }
        userSaveRequestDto.setPassword(passwordEncoder.encode(userSaveRequestDto.getPassword()));   // 패스워드 암호화 시켜 저장
        return userRepository.save(userSaveRequestDto.toEntity())
                .getId();
    }

    @Transactional // 로그인
    public String signIn(UserSignInRequestDto userSignInRequestDto) {
        User user = userRepository.findByEmail(userSignInRequestDto.getEmail()) // 아이디 확인
                .orElseThrow(() -> new IllegalAccessError("해당 아이디가 존재하지 않습니다."));

        if (!passwordEncoder.matches(userSignInRequestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호를 확인 해주세요.");   // 입력한 패스워드를 암호화 시켜서 저장된 패스워드와 비교
        }

        System.out.println(jwtTokenProvider.createToken(user.getUsername()));
        return jwtTokenProvider.createToken(user.getUsername()); // 토큰 생성후 반환
    }

    //업데이트는 일반 정보(닉네임, 상태메세지), 패스워드, 프로필사진 따로 분리
    @Transactional // user 정보 수정
    public Long update(Long id, UserUpdateRequestDto userUpdateRequestDto) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 유저가 존재하지 않습니다."));
        user.update(userUpdateRequestDto.getNickname(), userUpdateRequestDto.getStateComment());
        return id;
    }

    @Transactional // user 비밀번호 수정
    public Long updatePassword(Long id, UserUpdatePasswordRequestDto userUpdatePasswordRequestDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 유저가 존재하지 않습니다."));
        user.updatePassword(passwordEncoder.encode(userUpdatePasswordRequestDto.getPassword()));
        return id;
    }

    @Transactional  // user 프로필 이미지 수정
    public Long updateProfileImage(Long id, MultipartFile file) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 유저가 존재하지 않습니다."));
        if (file != null){
            File folder = new File(imagePath + user.getEmail());
            deleteFolder(folder); // 기존에 사진이 저장되었던 폴더를 삭제
            folder.mkdirs(); // 새 사진을 저장하기위해 새로운 폴더 생성
            String originalFileName = file.getOriginalFilename();
            String filePath = imagePath + user.getEmail() + "/" + originalFileName;
            File dest = new File(filePath);
            file.transferTo(dest);
            user.updateProfileImage(filePath);
        }
        return id;
    }
    @Transactional  // user 정보 삭제(회원 탈퇴)
    public Long delete(Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 유저가 존재하지 않습니다."));
        File folder = new File(imagePath + user.getEmail()); // 회원탈퇴시 프로필 사진 저장 폴더 삭제
        deleteFolder(folder);
        userRepository.delete(user);
        return id;
    }

    public void deleteFolder(File folder){ // 폴더를 제거하기 위해서는 폴더 내부의 모든 파일을 삭제하고 난뒤에 지울수 있음
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
