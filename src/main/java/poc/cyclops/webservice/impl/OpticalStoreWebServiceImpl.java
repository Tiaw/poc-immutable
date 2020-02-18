package poc.cyclops.webservice.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poc.cyclops.dto.OpticalStoreDto;
import poc.cyclops.service.OpticalStoreService;
import poc.cyclops.webservice.OpticalStoreWebService;

@Service
public class OpticalStoreWebServiceImpl implements OpticalStoreWebService {

    private OpticalStoreService opticalStoreService;

    @Autowired
    public OpticalStoreWebServiceImpl(OpticalStoreService employeService) {
        this.opticalStoreService = employeService;
    }

    @Override
    public Optional<OpticalStoreDto> findById(Long id) {
        return opticalStoreService.findById(id);
    }

    @Override
    public OpticalStoreDto findByIdNotOptional(Long id) {
        return opticalStoreService.findById(id).orElse(null);
    }

    @Override
    public List<OpticalStoreDto> findByName(String name) {
        return opticalStoreService.findByName(name);
    }

}
