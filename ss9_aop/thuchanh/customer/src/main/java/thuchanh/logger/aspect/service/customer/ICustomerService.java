package thuchanh.logger.aspect.service.customer;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import thuchanh.logger.aspect.model.Customer;
import thuchanh.logger.aspect.model.Province;
import thuchanh.logger.aspect.service.IGeneralService;


public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAll(Pageable pageable);
}
