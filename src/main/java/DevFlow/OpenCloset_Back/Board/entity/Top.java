package DevFlow.OpenCloset_Back.Board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Top extends Gener{
    @OneToOne
    @JoinColumn(name = "board_id", unique = true)
    private Board board;

    public Top(Board board) {
        this.board = board;
    }
}
