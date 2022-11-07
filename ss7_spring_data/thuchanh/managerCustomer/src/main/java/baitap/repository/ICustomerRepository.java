package baitap.repository;

import baitap.model.Customer;
import baitap.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
