package DevFlow.OpenCloset_Back.Board.dto.req;

import lombok.Getter;

@Getter
public class BoardCreateRequestDto {
    private String title;
    private String description;
    private String image;
    private String size;
    private String sex;
    private String place;
    private int price;
    private int date;
    private String category;
}
