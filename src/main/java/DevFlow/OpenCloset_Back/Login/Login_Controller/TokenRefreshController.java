package DevFlow.OpenCloset_Back.Login.Login_Controller;

import DevFlow.OpenCloset_Back.Login.Dto.req.RefreshTokenRequestDto;
import DevFlow.OpenCloset_Back.Login.Jwt_Util.JwtUtil;
import DevFlow.OpenCloset_Back.Login.RefreshToken.RefreshToken;
import DevFlow.OpenCloset_Back.Login.RefreshToken.RefreshTokenService;
import DevFlow.OpenCloset_Back.Login.Dto.res.TokenRefreshResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class TokenRefreshController {

    private final RefreshTokenService refreshTokenService;

    @PostMapping("/refresh")
    public ResponseEntity<TokenRefreshResponseDto> refreshAccessToken(@RequestBody RefreshTokenRequestDto requestDto) {
        String refreshToken = requestDto.getRefreshToken();

        return refreshTokenService.findByToken(refreshToken)
                .map(token -> {
                    String newAccessToken = JwtUtil.generateToken(token.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponseDto(newAccessToken));
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Invalid refresh token"));
    }
}
