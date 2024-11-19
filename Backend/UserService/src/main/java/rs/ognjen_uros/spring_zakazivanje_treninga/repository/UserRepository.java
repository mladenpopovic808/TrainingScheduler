package rs.ognjen_uros.spring_zakazivanje_treninga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ognjen_uros.spring_zakazivanje_treninga.domain.Manager;
import rs.ognjen_uros.spring_zakazivanje_treninga.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsernameAndPassword(String username, String password);

    User findUserByEmailAndPassword(String email, String password);
    User findUserByEmail(String email);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByUserKey(String userKey);

}
