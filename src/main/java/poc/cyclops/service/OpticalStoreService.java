package poc.cyclops.service;

import io.vavr.collection.Seq;
import io.vavr.control.Option;
import poc.cyclops.dto.OpticalStoreAddressDto;
import poc.cyclops.dto.OpticalStoreDto;

public interface OpticalStoreService {
    Option<OpticalStoreDto> findById(Long id);

    Seq<OpticalStoreDto> findByName(String name);

    Seq<OpticalStoreAddressDto> findAddressByName(String name);

}
