package poc.cyclops.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.vavr.collection.Seq;
import io.vavr.collection.Vector;
import io.vavr.control.Option;
import poc.cyclops.domain.OpticalStore;
import poc.cyclops.dto.OpticalStoreAddressDto;
import poc.cyclops.dto.OpticalStoreDto;
import poc.cyclops.repository.OpticalStoreRepository;
import poc.cyclops.service.OpticalStoreService;
import poc.cyclops.wrapper.OpticalWrapper;

@Service
public class OpticalStoreServiceImpl implements OpticalStoreService {

    private OpticalStoreRepository opticalStoreRepository;

    @Autowired
    public OpticalStoreServiceImpl(OpticalStoreRepository employeRepository) {
        this.opticalStoreRepository = employeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Option<OpticalStoreDto> findById(Long id) {
        return opticalStoreRepository.findById(id).map(OpticalWrapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Seq<OpticalStoreDto> findByName(String name) {
        return opticalStoreRepository.streamFetchEmployeesByName(name, OpticalStore.class)
                                     .map(OpticalWrapper::toDto)
                                     .collect(Vector.collector());
    }

    @Override
    @Transactional(readOnly = true)
    public Seq<OpticalStoreAddressDto> findAddressByName(String name) {
        return opticalStoreRepository.streamByName(name, OpticalStoreAddressDto.class).collect(Vector.collector());
    }
}
