package rs.ognjen_uros.spring_zakazivanje_treninga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ognjen_uros.spring_zakazivanje_treninga.domain.Manager;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Manager findByEmailManagerAndPassword(String emailManager, String password);
    Manager findManagerByEmailManager(String emailManager);
    Optional<Manager> findByEmailManager(String emailManager);
}
