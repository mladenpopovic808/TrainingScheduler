package rs.ognjen_uros.spring_zakazivanje_treninga.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(indexes = {@Index(columnList = "usernameManager", unique = true), @Index(columnList = "emailManager", unique = true)})
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emailManager;
    private String salaName;
    private String firstName;
    private String lastName;
    private String usernameManager;
    private String password;


}
