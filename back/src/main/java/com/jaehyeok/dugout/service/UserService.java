package com.jaehyeok.dugout.service;

import com.jaehyeok.dugout.domain.User;
import com.jaehyeok.dugout.dto.UserResponseDto;
import com.jaehyeok.dugout.dto.UserSaveRequestDto;
import com.jaehyeok.dugout.dto.UserUpdateRequestDto;
import com.jaehyeok.dugout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    // 유저 - 목록 조회
    @Transactional
    public List<UserResponseDto> findAll(){
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }
    // 유저 - 상세 조회
    @Transactional
    public UserResponseDto findById(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalAccessError("[userId=" + userId + "] 해당 유저가 존재하지 않습니다."));
        return new UserResponseDto(user);
    }
    // 유저 - 등록
    @Transactional
    public Long save(UserSaveRequestDto userSaveRequestDto){
        return userRepository.save(userSaveRequestDto.toEntity())
                .getId();
    }
    // 유저 - 수정
    @Transactional
    public Long update(Long userId, UserUpdateRequestDto userUpdateRequestDto){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalAccessError("[userId=" + userId + "] 해당 유저가 존재하지 않습니다."));
        user.update(userUpdateRequestDto.getPassword(), userUpdateRequestDto.getNickname(), userUpdateRequestDto.getPhoto(), userUpdateRequestDto.getStateComment());
        return userId;
    }
    // 유저 - 삭제
    @Transactional
    public void delete(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalAccessError("[userId=" + userId + "] 해당 게시글이 존재하지 않습니다."));
        userRepository.delete(user);
    }
}
