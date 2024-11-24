package rs.ognjen_uros.sala_spring_zakazivanje_treninga.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@NoArgsConstructor
public class Termin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Boolean isScheduled;
    private Integer maximumNumberOfAvailableSpots;
    private Integer numberOfAvailableSpots;
    private Integer minimumNumberOfAvailableSpots;
    private String dayOfTheWeek;
    @ManyToOne(optional = false)
    private Training training;
    @ManyToOne(optional = false)
    private Sala sala;
    private boolean scheduled;
}
