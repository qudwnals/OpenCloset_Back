package DevFlow.OpenCloset_Back.Board.dto.req;

import lombok.Getter;

@Getter
public class BoardCreateRequestDto {
    private String title;
    private String description;
    private String image;
    private String size;
    private Boolean sex;
    private String place;

}
