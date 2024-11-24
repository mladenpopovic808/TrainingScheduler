package rs.ognjen_uros.spring_zakazivanje_treninga.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(indexes = {@Index(columnList = "username", unique = true), @Index(columnList = "email", unique = true)})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String membershipId;
    private String email;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String username;
    private String password;
    private Integer numberOfSessions;
    private String userKey;
    private Boolean isActivated;
    private Boolean isDeleted;
    @ManyToOne(optional = false)
    private Role role;




    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", membershipId='" + membershipId + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", numberOfSessions=" + numberOfSessions +
                ", userKey='" + userKey + '\'' +
                ", isActivated=" + isActivated +
                ", isDeleted=" + isDeleted +
                ", role=" + role +
                '}';
    }
}
