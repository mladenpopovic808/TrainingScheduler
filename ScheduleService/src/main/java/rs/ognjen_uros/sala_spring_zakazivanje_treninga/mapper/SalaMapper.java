package rs.ognjen_uros.sala_spring_zakazivanje_treninga.mapper;

import org.springframework.stereotype.Component;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.domain.Sala;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.domain.Termin;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.dto.SalaDto;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.dto.TerminDto;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.repository.TrainingTypeRepository;

@Component
public class SalaMapper {


    public TerminDto terminToTerminDto(Termin termin){
        TerminDto terminDto = new TerminDto();
        terminDto.setStart(termin.getStart());
        terminDto.setEnd(termin.getEnd());
        terminDto.setTrainingType(termin.getTrainingType().getTypeOfTraining());
        terminDto.setTrainingName(termin.getTrainingType().getName());
        terminDto.setAvailableSpots(termin.getNumberOfAvailableSpots());
        terminDto.setSalaId(termin.getSala().getId());
        terminDto.setMaximumAvailableSpots(termin.getMaximumNumberOfAvailableSpots());
        terminDto.setMinimumAvailableSpots(termin.getMinimumNumberOfAvailableSpots());

        return terminDto;
    }

}
