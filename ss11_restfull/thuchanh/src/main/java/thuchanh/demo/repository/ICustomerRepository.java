package thuchanh.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thuchanh.demo.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
