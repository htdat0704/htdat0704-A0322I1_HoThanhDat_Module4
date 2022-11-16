package thuchanh.logger.aspect.service.province;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thuchanh.logger.aspect.model.Province;
import thuchanh.logger.aspect.repository.IProvinceRepository;

import java.util.Optional;

@Service
public class ProvindeService implements IProvindeService{

    @Autowired
    private IProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Province province) {

    }

    @Override
    public void remove(Long id) {

    }
}
