package DevFlow.OpenCloset_Back.Login.Dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private String username;
    private String name;
    private String message;
    private String accessToken;
    private String refreshToken;

    public LoginResponseDto(String username, String name, String message, String accessToken, String refreshToken) {
        this.username = username;
        this.name = name;
        this.message = message;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
