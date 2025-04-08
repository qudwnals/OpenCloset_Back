package DevFlow.OpenCloset_Back.Login.Login_Service;
import DevFlow.OpenCloset_Back.Login.Dto.req.LoginRequestDto;
import DevFlow.OpenCloset_Back.Login.Dto.res.LoginResponseDto;
import DevFlow.OpenCloset_Back.Login.Jwt_Util.JwtUtil;
import DevFlow.OpenCloset_Back.User.User_Repository.UserRepository;
import DevFlow.OpenCloset_Back.User.entity.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public LoginResponseDto loginUser(LoginRequestDto requestDto) {
        Optional<User> optionalUser = userRepository.findByUsername(requestDto.getUsername());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
                //  JWT 토큰 생성
                String token = JwtUtil.generateToken(user.getUsername());

                //  토큰 포함해서 응답 반환
                return new LoginResponseDto(user.getUsername(), user.getName(), "Login successful", token);
            }
        }

        //로그인 실패 시
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
    }

    public void logoutUser(HttpSession session) {
        session.invalidate(); // 세션 무효화 (로그아웃)
    }
}