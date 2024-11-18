package rs.ognjen_uros.spring_zakazivanje_treninga.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rs.ognjen_uros.spring_zakazivanje_treninga.domain.Manager;
import rs.ognjen_uros.spring_zakazivanje_treninga.dto.*;

public interface UserService {

    Page<UserDto> findAll(Pageable pageable);

    UserDto getUserById(Long id);
    UserDto getUserByEmail(String email);
    ManagerDto getManagerById(Long id);
    ManagerDto getManagerByEmail(String email);
    UserDto add(UserCreateDto userCreateDto);

    String findByToken(String token);
    void updateUserNumberOfSessions(Long userid);
    UserDto activate(String userKey);
    UserDto update(UserChangeDto userDto, Long id);
    ManagerDto saveManager(ManagerCreateDto managerCreateDto);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);
}
