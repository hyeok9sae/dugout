package com.jaehyeok.dugout.service;

import com.jaehyeok.dugout.dto.UserSaveRequestDto;
import com.jaehyeok.dugout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    // 유저 - 등록
    @Transactional
    public Long save(UserSaveRequestDto userSaveRequestDto){
        return userRepository.save(userSaveRequestDto.toEntity())
                .getId();
    }
}
