package rs.ognjen_uros.sala_spring_zakazivanje_treninga.mapper;

import org.springframework.stereotype.Component;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.domain.Termin;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.dto.TerminDto;

@Component
public class SalaMapper {


    public TerminDto terminToTerminDto(Termin termin){
        TerminDto terminDto = new TerminDto();
        terminDto.setStart(termin.getStart());
        terminDto.setEnd(termin.getEnd());
        terminDto.setTrainingType(termin.getTraining().getTrainingType());
        terminDto.setTrainingName(termin.getTraining().getName());
        terminDto.setAvailableSpots(termin.getNumberOfAvailableSpots());
        terminDto.setSalaId(termin.getSala().getId());
        terminDto.setMaximumAvailableSpots(termin.getMaximumNumberOfAvailableSpots());
        terminDto.setMinimumAvailableSpots(termin.getMinimumNumberOfAvailableSpots());

        return terminDto;
    }

}
