package rs.ognjen_uros.spring_zakazivanje_treninga.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String dateOfBirth;
    private Integer numberOfSessions;


}
