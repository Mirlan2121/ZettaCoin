package ZettaCoin.demo1.reposistory;

import ZettaCoin.demo1.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    Optional<Developer> findByLogin(String Login);

}
