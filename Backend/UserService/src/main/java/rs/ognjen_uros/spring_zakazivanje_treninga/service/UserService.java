package rs.ognjen_uros.spring_zakazivanje_treninga.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ognjen_uros.spring_zakazivanje_treninga.domain.Manager;
import rs.ognjen_uros.spring_zakazivanje_treninga.domain.User;
import rs.ognjen_uros.spring_zakazivanje_treninga.domain.VerificationToken;
import rs.ognjen_uros.spring_zakazivanje_treninga.dto.*;
import rs.ognjen_uros.spring_zakazivanje_treninga.exception.NotFoundException;
import rs.ognjen_uros.spring_zakazivanje_treninga.helper.MessageHelper;
import rs.ognjen_uros.spring_zakazivanje_treninga.mapper.ManagerMapper;
import rs.ognjen_uros.spring_zakazivanje_treninga.mapper.UserMapper;
import rs.ognjen_uros.spring_zakazivanje_treninga.repository.ManagerRepository;
import rs.ognjen_uros.spring_zakazivanje_treninga.repository.UserRepository;
import rs.ognjen_uros.spring_zakazivanje_treninga.secutiry.service.TokenService;

import java.sql.Timestamp;

@Service
@Transactional

public class UserService {

    private TokenService tokenService;
    private UserRepository userRepository;
    private ManagerRepository managerRepository;
    private UserMapper userMapper;
    private ManagerMapper managerMapper;
    private JmsTemplate jmsTemplate;
    private MessageHelper messageHelper;
    private String sendVerificationForUser;
    @Value("${thisServiceUrl}")
    private String thisServiceUrl;

    public UserService(TokenService tokenService, UserRepository userRepository,
                       ManagerRepository managerRepository, UserMapper userMapper, ManagerMapper managerMapper,
                       JmsTemplate jmsTemplate, MessageHelper messageHelper, @Value("${destination.sendVerificationForUser}")String sendVerificationForUser) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.managerRepository = managerRepository;
        this.userMapper = userMapper;
        this.managerMapper = managerMapper;
        this.jmsTemplate = jmsTemplate;
        this.messageHelper = messageHelper;
        this.sendVerificationForUser = sendVerificationForUser;
    }


    public Page<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::userToUserDto);
    }


    public Page<ManagerDto> findAllManagers(Pageable pageable) {
        return managerRepository.findAll(pageable)
                .map(managerMapper::managerToManagerDto);
    }


    public UserDto getUserById(Long id) {
        User user = userRepository.findUserById(id).orElseThrow(() -> new NotFoundException(String.format("User with key: %s not found.", id)));
        return userMapper.userToUserDto(user);
    }


    public UserDto getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        if(user == null){
            return null;
        }
        return userMapper.userToUserDto(user);
    }


    public ManagerDto getManagerById(Long id) {
        Manager manager = managerRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Manager with key: %s not found.", id)));
        return managerMapper.managerToManagerDto(manager);
    }


    public ManagerDto getManagerByEmail(String email) {
        Manager manager = managerRepository.findManagerByEmailManager(email);
        if(manager == null){
            return null;
        }
        return managerMapper.managerToManagerDto(manager);
    }


    public UserDto register(UserCreateDto userCreateDto) {
        User user = userMapper.userCreateDtoToUser(userCreateDto);
        tokenService.save(user, user.getUserKey());
        userRepository.save(user);

        //Prilikom registracije,salje se mejl potvrda. preko ActiveMQ Brokera saljemo to na email servis.
        jmsTemplate.convertAndSend(sendVerificationForUser, messageHelper.createTextMessage(new SendVerificationLinkToUserDto(user.getId(),
                user.getFirstName(), user.getLastName(), user.getEmail(), thisServiceUrl+"/user/activate/"+user.getUserKey())));
        return userMapper.userToUserDto(user);
    }


    public String findByToken(String token) {
        String jwt = token.substring(7);//BEARER "..."
        Claims claims = tokenService.extractAllClaims(jwt);
        String email = claims.getSubject();
        return email;
    }


    public void updateUserNumberOfSessions(Long userid) {
        User user = userRepository.findUserById(userid)
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with key: %s not found.", userid)));
        user.setNumberOfSessions(user.getNumberOfSessions() + 1);
        userRepository.save(user);
    }


    public UserDto activate(String userKey) {
        User user = userRepository.findUserByUserKey(userKey).orElseThrow(() -> new NotFoundException(String.format("User with key: %s not found.", userKey)));
        VerificationToken verificationToken = tokenService.findByToken(userKey);
        //System.out.println(verificationToken.getUser().getFirstName());
        if(verificationToken == null){
            return null;
        }
        //Proveravamo da li je token jos uvek vremenski validan
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if(timestamp.before(verificationToken.getExpireDate())){
            user.setIsActivated(true);
            userRepository.save(user);
        }
        return userMapper.userToUserDto(user);
    }

    public UserDto update(UserChangeDto userDto) {
        User user = userRepository.findUserById(userDto.getId()).orElseThrow(() -> new NotFoundException(String.format("User with id: %s not found.", userDto.getId())));
        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        UserDto ret = userMapper.userToUserDto(user);
        System.out.println(user);
        System.out.println(ret);
        return ret;
    }
    public ManagerDto updateManager(ManagerCreateDto managerDto,long id) {
        Manager manager = managerRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("User with id: %s not found.", id)));
        manager.setUsernameManager(managerDto.getUsernameManager());
        manager.setFirstName(managerDto.getFirstName());
        manager.setLastName(managerDto.getLastName());
        manager.setEmailManager(managerDto.getEmailManager());
        manager.setPassword(managerDto.getPassword());
        manager.setSalaName(managerDto.getSalaName());

        ManagerDto ret = managerMapper.managerToManagerDto(manager);

        return ret;
    }


    public ManagerDto saveManager(ManagerCreateDto managerCreateDto) {
        Manager manager = new Manager();
        manager.setEmailManager(managerCreateDto.getEmailManager());
        manager.setPassword(managerCreateDto.getPassword());
        manager.setUsernameManager(managerCreateDto.getUsernameManager());
        manager.setSalaName(managerCreateDto.getSalaName());
        manager.setFirstName(managerCreateDto.getFirstName());
        manager.setLastName(managerCreateDto.getLastName());
        managerRepository.save(manager);
        //Samo useru se salje email
        return managerMapper.managerToManagerDto(manager);
    }


    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        User user = userRepository.findUserByEmailAndPassword(tokenRequestDto.getEmail(), tokenRequestDto.getPassword());
        if(user != null) {
            //pravimo mu token
            Claims claims = Jwts.claims();
            claims.put("id", user.getId());
            claims.put("role", user.getRole().getName());
            claims.put("email", user.getEmail());
            claims.put("isActive", user.getIsActivated());
            claims.put("isDeleted", user.getIsDeleted());
            return new TokenResponseDto(tokenService.generate(claims));
        }
        Manager manager = managerRepository.findByEmailManagerAndPassword(tokenRequestDto.getEmail(), tokenRequestDto.getPassword());
        if(manager != null) {
            Claims claims = Jwts.claims();
            claims.put("id", manager.getId());
            claims.put("email", manager.getEmailManager());
            claims.put("salaName", manager.getSalaName());
            return new TokenResponseDto(tokenService.generate(claims));
        }
        return null;
    }
}
