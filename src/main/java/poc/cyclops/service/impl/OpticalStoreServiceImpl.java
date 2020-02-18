package poc.cyclops.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poc.cyclops.domain.OpticalStore;
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
    @Transactional
    public Optional<OpticalStoreDto> findById(Long id) {
        return opticalStoreRepository.findById(id).map(OpticalWrapper::toDto);
    }

    @Override
    @Transactional
    public List<OpticalStoreDto> findByName(String name) {
        return opticalStoreRepository.streamByName(name, OpticalStore.class)
                                     .map(OpticalWrapper::toDto)
                                     .collect(toList());
    }

}
