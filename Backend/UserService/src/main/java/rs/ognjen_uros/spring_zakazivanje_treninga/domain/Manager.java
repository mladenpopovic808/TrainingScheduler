package rs.ognjen_uros.spring_zakazivanje_treninga.domain;

import javax.persistence.*;

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

    public Long getId() {
        return id;
    }

    public String getEmailManager() {
        return emailManager;
    }
    public String getSalaName() {
        return salaName;
    }

    public void setSalaName(String salaName) {
        this.salaName = salaName;
    }

    public String getUsernameManager() {
        return usernameManager;
    }

    public void setUsernameManager(String usernameManager) {
        this.usernameManager = usernameManager;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return emailManager;
    }

    public void setEmail(String email) {
        this.emailManager = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
