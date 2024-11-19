package rs.ognjen_uros.spring_zakazivanje_treninga.mapper;


import org.springframework.stereotype.Component;
import rs.ognjen_uros.spring_zakazivanje_treninga.domain.Manager;
import rs.ognjen_uros.spring_zakazivanje_treninga.dto.ManagerCreateDto;
import rs.ognjen_uros.spring_zakazivanje_treninga.dto.ManagerDto;
import rs.ognjen_uros.spring_zakazivanje_treninga.repository.RoleRepository;

@Component
public class ManagerMapper {

    private final RoleRepository roleRepository;

    public ManagerMapper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public ManagerDto managerToManagerDto(Manager manager) {
        ManagerDto managerDto = new ManagerDto();
        managerDto.setEmailManager(manager.getEmailManager());
        managerDto.setFirstName(manager.getFirstName());
        managerDto.setLastName(manager.getLastName());
        managerDto.setSalaName(manager.getSalaName());
        managerDto.setUsernameManager(manager.getUsernameManager());
        managerDto.setId(manager.getId());
        managerDto.setPassword(manager.getPassword());

        return managerDto;
    }

    public Manager managerCreateDtoToManager(ManagerCreateDto managerCreateDto) {
        Manager manager = new Manager();
        manager.setEmailManager(managerCreateDto.getEmailManager());
        manager.setFirstName(managerCreateDto.getFirstName());
        manager.setLastName(managerCreateDto.getLastName());
        manager.setSalaName(managerCreateDto.getSalaName());
        manager.setUsernameManager(managerCreateDto.getUsernameManager());
        manager.setPassword(managerCreateDto.getPassword());
        return manager;
    }
}
