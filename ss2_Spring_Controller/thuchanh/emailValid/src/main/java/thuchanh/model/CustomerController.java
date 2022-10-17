package thuchanh.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/bai3")
public class CustomerController {

    @Autowired
    private static CustomerRepository customerRepository = new CustomerRepository();

    @GetMapping()
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerRepository.list();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customers/info");
        Customer customer = customerRepository.findById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping()
    public ModelAndView update(@RequestParam Long id,
                               @RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String address) {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        customerRepository.update(new Customer(id,name,email,address));
        modelAndView.addObject("customers", customerRepository.list());
        return modelAndView;
    }

}
