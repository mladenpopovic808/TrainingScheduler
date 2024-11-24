package rs.ognjen_uros.sala_spring_zakazivanje_treninga.dto;


import lombok.Data;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.domain.TrainingType;

import java.time.LocalDateTime;

@Data
public class UserTerminResponseDto {

    private Long id;
    private Long terminId;
    private Long userId;
    private String salaName;
    private LocalDateTime start;
    private LocalDateTime end;
    private String trainingName;
    private TrainingType trainingType;
}

