package poc.cyclops.webservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.vavr.collection.Seq;
import io.vavr.control.Option;
import poc.cyclops.dto.OpticalStoreAddressDto;
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
    public Option<OpticalStoreDto> findById(Long id) {
        return opticalStoreService.findById(id);
    }

    @Override
    public OpticalStoreDto findByIdNotOptional(Long id) {
        return opticalStoreService.findById(id).getOrNull();
    }

    @Override
    public Seq<OpticalStoreDto> findByName(String name) {
        return opticalStoreService.findByName(name);
    }

    @Override
    public Seq<OpticalStoreAddressDto> findAddressByName(String name) {
        return opticalStoreService.findAddressByName(name);
    }

}
