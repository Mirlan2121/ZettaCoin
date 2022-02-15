package ZettaCoin.demo1.reposistory;

import ZettaCoin.demo1.entity.Developer;
import ZettaCoin.demo1.entity.DeveloperRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeveloperRoleRepository extends JpaRepository<DeveloperRole, Long> {
    Optional<DeveloperRole>findByDeveloper(Developer developer);
}
