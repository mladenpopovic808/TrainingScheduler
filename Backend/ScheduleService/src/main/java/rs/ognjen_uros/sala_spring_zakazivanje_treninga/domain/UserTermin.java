package rs.ognjen_uros.sala_spring_zakazivanje_treninga.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class UserTermin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long terminId;
    private int price;

    public UserTermin(Long userId, Long terminId, int price) {
        this.userId = userId;
        this.terminId = terminId;
        this.price = price;
    }




}
