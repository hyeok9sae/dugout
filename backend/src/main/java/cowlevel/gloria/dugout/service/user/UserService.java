package cowlevel.gloria.dugout.service.user;

import cowlevel.gloria.dugout.dto.user.UserResponseDto;
import cowlevel.gloria.dugout.dto.user.UserSaveRequestDto;
import cowlevel.gloria.dugout.dto.user.UserUpdatePasswordRequestDto;
import cowlevel.gloria.dugout.dto.user.UserUpdateRequestDto;
import cowlevel.gloria.dugout.entity.user.User;
import cowlevel.gloria.dugout.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

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
    public Long save(UserSaveRequestDto userSaveRequestDto){
        return userRepository.save(userSaveRequestDto.toEntity())
                .getId();
    }

    @Transactional // user 정보 수정
    public Long update(Long id, UserUpdateRequestDto userUpdateRequestDto){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 유저가 존재하지 않습니다."));
        user.update(userUpdateRequestDto.getNickname(), userUpdateRequestDto.getPhoto(), userUpdateRequestDto.getStateComment());
        return id;
    }

    @Transactional // user 비밀번호 수정
    public Long updatePassword(Long id, UserUpdatePasswordRequestDto userUpdatePasswordRequestDto){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 유저가 존재하지 않습니다."));
        user.updatePassword(userUpdatePasswordRequestDto.getPassword());
        return id;
    }

    @Transactional  // user 정보 삭제
    public Long delete(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 유저가 존재하지 않습니다."));
        userRepository.delete(user);
        return id;
    }
}
