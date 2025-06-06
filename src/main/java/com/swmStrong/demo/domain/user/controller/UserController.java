package com.swmStrong.demo.domain.user.controller;


import com.swmStrong.demo.common.response.ApiResponse;
import com.swmStrong.demo.common.exception.code.SuccessCode;
import com.swmStrong.demo.common.response.CustomResponseEntity;
import com.swmStrong.demo.domain.user.dto.UnregisteredRequestDto;
import com.swmStrong.demo.domain.user.dto.UserRequestDto;
import com.swmStrong.demo.domain.user.dto.UserResponseDto;
import com.swmStrong.demo.domain.user.service.UserService;
import com.swmStrong.demo.util.token.dto.TokenResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "비회원")
@RestController
@RequiredArgsConstructor
@RequestMapping("/guest-users")
public class UserController {
    private final UserService userService;

    @Operation(
            summary = "유저 생성",
            description =
                    "<p> 새로운 유저를 생성한다.</p>"
    )
    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDto>> createGuestUser(@RequestBody UserRequestDto userRequestDto) {
        return CustomResponseEntity.of(
                SuccessCode._CREATED,
                userService.registerGuestNickname(userRequestDto)
        );
    }

    @Operation(
            summary = "닉네임의 중복 여부를 확인한다.",
            description =
                    "<p> 중복일 경우 true, 중복이 아닐 경우 false를 반환한다. </p>"
    )
    @GetMapping("/is-nickname-duplicated")
    public ResponseEntity<ApiResponse<Boolean>> isGuestNicknameRegistered(@RequestParam(required = true) String nickname) {
        return CustomResponseEntity.of(
                SuccessCode._OK,
                userService.isGuestNicknameDuplicated(nickname)
        );
    }

    @Operation(
            summary = "비회원용 토큰 발급",
            description =
                "<p> 비회원용 토큰 발급 수단이다. </p>" +
                "<p> 등록일시같은 추가적인 유저 구분 수단을 반드시 보관하고 있고, 토큰 발급 시 넣어야 한다.</p>"
    )
    @PostMapping("/get-token")
    public ResponseEntity<ApiResponse<TokenResponseDto>> getToken(HttpServletRequest request, @RequestBody UnregisteredRequestDto unregisteredRequestDto) {
        return CustomResponseEntity.of(
                SuccessCode._CREATED,
                userService.getToken(request, unregisteredRequestDto)
        );
    }
}
