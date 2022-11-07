package baitap.service.customer;

import baitap.model.Customer;
import baitap.model.Province;
import baitap.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAll(Pageable pageable);
}
