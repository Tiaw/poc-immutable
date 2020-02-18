package poc.cyclops.service;

import java.util.List;
import java.util.Optional;

import poc.cyclops.dto.OpticalStoreAddressDto;
import poc.cyclops.dto.OpticalStoreDto;

public interface OpticalStoreService {
    public Optional<OpticalStoreDto> findById(Long id);

    List<OpticalStoreDto> findByName(String name);

    List<OpticalStoreAddressDto> findAddressByName(String name);

}
