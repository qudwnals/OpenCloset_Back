package DevFlow.OpenCloset_Back.User.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponeDto {
    private String username;
    private String name;
    private String address;
    private String age;

    public UserResponeDto(String username, String address, String name, String age) {
        this.username = username;
        this.address = address;
        this.name = name;
        this.age = age;
    }
}
