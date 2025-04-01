package DevFlow.OpenCloset_Back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Default {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
