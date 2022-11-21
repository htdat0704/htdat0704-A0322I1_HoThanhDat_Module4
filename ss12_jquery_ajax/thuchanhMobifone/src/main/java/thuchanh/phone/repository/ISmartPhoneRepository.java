package thuchanh.phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thuchanh.phone.model.SmartPhone;

public interface ISmartPhoneRepository extends JpaRepository<SmartPhone, Long> {
}
