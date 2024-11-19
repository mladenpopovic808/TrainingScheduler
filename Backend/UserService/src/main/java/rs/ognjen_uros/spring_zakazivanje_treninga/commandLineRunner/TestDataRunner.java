package rs.ognjen_uros.spring_zakazivanje_treninga.commandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import rs.ognjen_uros.spring_zakazivanje_treninga.domain.Manager;
import rs.ognjen_uros.spring_zakazivanje_treninga.domain.Role;
import rs.ognjen_uros.spring_zakazivanje_treninga.domain.User;
import rs.ognjen_uros.spring_zakazivanje_treninga.repository.ManagerRepository;
import rs.ognjen_uros.spring_zakazivanje_treninga.repository.RoleRepository;
import rs.ognjen_uros.spring_zakazivanje_treninga.repository.UserRepository;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private ManagerRepository managerRepository;

    public TestDataRunner(ManagerRepository managerRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.managerRepository = managerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role roleUser = new Role("ROLE_USER", "User role");
        Role roleAdmin = new Role("ROLE_ADMIN", "Admin role");
        roleRepository.save(roleUser);
        roleRepository.save(roleAdmin);


        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setUsername("admin");
        admin.setPassword("admin");


        for(int i=0;i<25;i++){
            User us=new User();
            us.setEmail("userX"+i+"@gmail.com");
            us.setFirstName("Marko"+i);
            us.setLastName("Pavlovic"+i);
            us.setUsername("MP"+i);
            us.setPassword("userY"+i);
            us.setRole(roleUser);
            us.setNumberOfSessions(0);
            userRepository.save(us);
        }

        for(int i=0;i<25;i++){
            Manager mng=new Manager();
            mng.setEmailManager("Manager"+i+"@gmail.com");
            mng.setFirstName("Borivoje "+i);
            mng.setLastName("Mitic "+i);
            mng.setUsernameManager("BM "+i);
            mng.setPassword("userY"+i);
            mng.setSalaName("Sala "+i);

            managerRepository.save(mng);
        }
        admin.setRole(roleAdmin);
        userRepository.save(admin);


    }
}
