package ZettaCoin.demo1.reposistory;

import ZettaCoin.demo1.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findById(Long id);
    Optional<Company> findByName(String name);
    Optional<Company> findByAddress(String address);

}
