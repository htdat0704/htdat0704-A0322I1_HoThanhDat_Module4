package thuchanh.logger.aspect.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thuchanh.logger.aspect.model.Province;

@Repository
public interface IProvinceRepository extends JpaRepository<Province, Long> {
}