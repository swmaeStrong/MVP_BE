package com.swmStrong.demo.domain.user.service;

import com.swmStrong.demo.domain.user.dto.UnregisteredRequestDto;
import com.swmStrong.demo.domain.user.dto.UserRequestDto;
import com.swmStrong.demo.domain.user.dto.UserResponseDto;
import com.swmStrong.demo.util.token.dto.TokenResponseDto;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    UserResponseDto registerGuestNickname(UserRequestDto userRequestDto);
    boolean isGuestNicknameDuplicated(String nickname);
    TokenResponseDto getToken(HttpServletRequest request, UnregisteredRequestDto unregisteredRequestDto);
}
