package ZettaCoin.demo1.reposistory;

import ZettaCoin.demo1.entity.CurrentCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrentCompanyRepository extends JpaRepository<CurrentCompany, Long> {
    Optional<CurrentCompany> findById(Long id);
    Optional<CurrentCompany> findByCompanyId(Long id);
}
