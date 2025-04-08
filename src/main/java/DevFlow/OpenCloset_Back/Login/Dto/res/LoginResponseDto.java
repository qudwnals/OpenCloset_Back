package DevFlow.OpenCloset_Back.Login.Dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private String username;
    private String name;
    private String message;
    private String token;

    public LoginResponseDto(String username, String name, String message, String token) {
        this.username = username;
        this.name = name;
        this.message = message;
        this.token = token;
    }
}
