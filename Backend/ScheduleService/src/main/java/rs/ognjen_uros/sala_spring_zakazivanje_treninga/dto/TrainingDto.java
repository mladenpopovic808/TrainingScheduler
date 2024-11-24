package rs.ognjen_uros.sala_spring_zakazivanje_treninga.dto;

import lombok.Data;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.domain.TrainingType;

@Data
public class TrainingDto {

    private String name;
    private TrainingType trainingType;
    private int price;


}
