package DevFlow.OpenCloset_Back.Board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Gener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
