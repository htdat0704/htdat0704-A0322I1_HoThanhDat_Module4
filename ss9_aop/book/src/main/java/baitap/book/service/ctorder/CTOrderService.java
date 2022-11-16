package baitap.book.service.ctorder;

import baitap.book.model.CTOrder;
import baitap.book.repository.ICTOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CTOrderService implements ICTOrderService{

    @Autowired
    private ICTOrderRepository repository;

    @Override
    public Page<CTOrder> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Iterable<CTOrder> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<CTOrder> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public void save(CTOrder ctOrder) {
        repository.save(ctOrder);
    }

    @Override
    public void delete(CTOrder ctOrder) {
        repository.delete(ctOrder);
    }
}
