package rs.ognjen_uros.sala_spring_zakazivanje_treninga.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.domain.TrainingType;

import java.time.LocalDateTime;

@Data
public class TerminDto {
    private Long salaId;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime start;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime end;
    private TrainingType trainingType;
    private String trainingName;
    private Integer minimumAvailableSpots;
    private Integer availableSpots;
    private Integer maximumAvailableSpots;



}

