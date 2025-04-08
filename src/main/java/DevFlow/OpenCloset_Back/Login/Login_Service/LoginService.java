package DevFlow.OpenCloset_Back.Login.Login_Service;
import DevFlow.OpenCloset_Back.Login.Dto.req.LoginRequestDto;
import DevFlow.OpenCloset_Back.Login.Dto.res.LoginResponseDto;
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

            // 비밀번호 검증
            if (passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
                return new LoginResponseDto(user.getUsername(), user.getName(), "로그인 성공!");
            }
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "잘못된 사용자명 또는 비밀번호");
    }
    public void logoutUser(HttpSession session) {
        session.invalidate(); // 세션 무효화 (로그아웃)
    }
}
