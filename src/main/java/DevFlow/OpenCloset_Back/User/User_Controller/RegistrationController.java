package DevFlow.OpenCloset_Back.User.User_Controller;

import DevFlow.OpenCloset_Back.Login.Dto.req.LoginRequestDto;
import DevFlow.OpenCloset_Back.Login.Dto.res.LoginResponseDto;
import DevFlow.OpenCloset_Back.User.User_Service.UserService;
import DevFlow.OpenCloset_Back.User.dto.req.UserCreateRequestDto;
import DevFlow.OpenCloset_Back.User.dto.res.UserResponeDto;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class RegistrationController {


    private final UserService userService;



    @PostMapping("/register")
    public ResponseEntity<UserResponeDto> registerUser(@RequestBody UserCreateRequestDto requestDto) {
        UserResponeDto responseDto = userService.registerUser(requestDto);
        return ResponseEntity.ok(responseDto);
    }
        @PostMapping("/login")
        public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto requestDto) {
            LoginResponseDto responseDto = userService.loginUser(requestDto);
            return ResponseEntity.ok(responseDto);

    }
}