package DevFlow.OpenCloset_Back.User_Controller;

import DevFlow.OpenCloset_Back.User_Service.UserService;
import dto.req.UserCreateRequestDto;
import dto.res.UserResponeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
}