package ZettaCoin.demo1.reposistory;


import ZettaCoin.demo1.entity.MetaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MetaDateRepository extends JpaRepository<MetaData, Long> {
//    Optional<MetaData> findById(Long id);
//    Optional<MetaData> findByDesiredId(Long id);
//    Optional<MetaData> findByCurrentId(Long id);
//    Optional<MetaData> findByFormerId(Long id);
}
