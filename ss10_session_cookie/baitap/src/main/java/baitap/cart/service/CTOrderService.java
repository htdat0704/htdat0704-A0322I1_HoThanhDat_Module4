package baitap.cart.service;

import baitap.cart.model.CTOrder;
import baitap.cart.model.Order;
import baitap.cart.repository.ICTOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CTOrderService implements ICTOrderService{

    @Autowired
    private ICTOrderRepository orderRepository;

    @Override
    public Iterable<CTOrder> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<CTOrder> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(CTOrder ctOrder) {
        orderRepository.save(ctOrder);
    }

    @Override
    public void delete(CTOrder ctOrder) {
        orderRepository.delete(ctOrder);
    }

    @Override
    public List<CTOrder> listDetail(long idOrder) {
        return orderRepository.listDetail(idOrder);
    }
}
