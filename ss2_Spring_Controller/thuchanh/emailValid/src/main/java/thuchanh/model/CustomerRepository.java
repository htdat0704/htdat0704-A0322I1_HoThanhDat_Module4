package thuchanh.model;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class CustomerRepository {

    private static List<Customer> list;

    static {
        list = new LinkedList<>();
        list.add(new Customer(1,"mot","mot","mot"));
        list.add(new Customer(2,"hai","hai","hai"));
        list.add(new Customer(3,"ba","ba","ba"));
        list.add(new Customer(4,"bon","bon","bon"));
    }

    public List<Customer> list(){
        return list;
    }

    public Customer findById(long id){
        for(Customer customer: list){
            if(customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

    public void update(Customer customer){
        int count = 0;
        for(Customer customerFound: list){
            if(customerFound.getId() == customer.getId()){
                break;
            }
            count ++;
        }
        if(count <= list.size()){
            list.add(count, customer);
        }
    }
}
