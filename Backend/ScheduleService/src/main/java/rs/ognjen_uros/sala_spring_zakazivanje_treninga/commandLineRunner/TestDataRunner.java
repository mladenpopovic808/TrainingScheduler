package rs.ognjen_uros.sala_spring_zakazivanje_treninga.commandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.domain.Sala;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.domain.TrainingType;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.domain.Training;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.repository.SalaRepository;
import rs.ognjen_uros.sala_spring_zakazivanje_treninga.repository.TrainingRepository;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

    private final SalaRepository salaRepository;
    private final TrainingRepository trainingRepository;

    public TestDataRunner(SalaRepository salaRepository, TrainingRepository trainingRepository) {
        this.salaRepository = salaRepository;
        this.trainingRepository = trainingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        for(int i=0;i<10;i++){
            Sala sala=new Sala();
            sala.setName("Sala " + i);
            sala.setAbout("Ova sala se zove " + sala.getName());
            sala.setNumberOfTrainers(5);
            salaRepository.save(sala);
        }

        //Kreiranje training Type-a
        Training tr=new Training();
        tr.setName("Cardio Boxing");
        tr.setPrice(10);
        tr.setTrainingType(TrainingType.GROUP);
        trainingRepository.save(tr);

        tr=new Training();
        tr.setName("Pilates");
        tr.setPrice(9);
        tr.setTrainingType(TrainingType.GROUP);
        trainingRepository.save(tr);

        tr=new Training();
        tr.setName("Glute & Core");
        tr.setPrice(9);
        tr.setTrainingType(TrainingType.GROUP);
        trainingRepository.save(tr);

        tr=new Training();
        tr.setName("Spinning");
        tr.setPrice(10);
        tr.setTrainingType(TrainingType.GROUP);
        trainingRepository.save(tr);

        tr=new Training();
        tr.setName("Full Body Workout");
        tr.setPrice(15);
        tr.setTrainingType(TrainingType.SOLO);
        trainingRepository.save(tr);
        ///////////////////////////////////////////

        /**
         *    @Id
         *     @GeneratedValue(strategy = GenerationType.IDENTITY)
         *     private Long id;
         *     private LocalDateTime start;
         *     private LocalDateTime end;
         *     private Boolean isScheduled;
         *     private Integer maximumNumberOfAvailableSpots;
         *     private Integer numberOfAvailableSpots;
         *     private Integer minimumNumberOfAvailableSpots;
         *     private String dayOfTheWeek;
         *     @ManyToOne(optional = false)
         *     private TrainingType trainingType;
         *     @ManyToOne(optional = false)
         *     private Sala sala;
         */






    }
}
