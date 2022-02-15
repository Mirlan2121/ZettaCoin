package ZettaCoin.demo1.reposistory;

import ZettaCoin.demo1.entity.Developer;
import ZettaCoin.demo1.entity.DeveloperInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeveloperInfoRepository extends JpaRepository<DeveloperInfo, Long> {
    Optional<DeveloperInfo> findById(Long id);
    Optional<DeveloperInfo> findByName(String name);
    Optional<DeveloperInfo> findBySerName(String serName);
    Optional<DeveloperInfo> findByDeveloper(Developer developer);
}
