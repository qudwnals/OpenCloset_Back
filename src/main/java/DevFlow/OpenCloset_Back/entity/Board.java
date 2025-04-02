package DevFlow.OpenCloset_Back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Board extends Default{ //게시물 id
    @Column(nullable = false)
    private String title;   //제목

    @Column(nullable = false)
    private String Description; //의류에 관한 설명

    @Column(nullable = false)
    private String image;   //의류 사진 (url로 단순 db 삽이 예정)

    @CreatedDate
    private LocalDateTime createdAt;    //엔티티가 생성되어 저장될 때 시간을 자동 저장

    @LastModifiedDate
    private LocalDateTime modifiedAt;   //엔티티가 수정된 시간을 자동 저장

    //회원아이디에 해당하는 FK값도 넣어야함 (회원 로직 구현 시)
}
