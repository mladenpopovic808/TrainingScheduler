package rs.ognjen_uros.sala_spring_zakazivanje_treninga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.domain.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    Training findByName(String name);
    Training findByTypeOfTraining(String typeOfTraining);
}
