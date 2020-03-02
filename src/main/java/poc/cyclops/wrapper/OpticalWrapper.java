package poc.cyclops.wrapper;

import static java.util.stream.Collectors.toSet;

import poc.cyclops.domain.Employee;
import poc.cyclops.domain.OpticalStore;
import poc.cyclops.dto.EmployeeDto;
import poc.cyclops.dto.OpticalStoreAddressDto;
import poc.cyclops.dto.OpticalStoreDto;
import poc.cyclops.view.OpticalStoreAddressView;

public class OpticalWrapper {
    private OpticalWrapper() {
    }

    public static EmployeeDto toDto(Employee entity) {
        return EmployeeDto.builder()
                          .setId(entity.getId())
                          .setFirstName(entity.getFirstName())
                          .setLastName(entity.getLastName())
                          .build();
    }

    public static OpticalStoreDto toDto(OpticalStore entity) {
        return OpticalStoreDto.builder()
                              .setId(entity.getId())
                              .setName(entity.getName())
                              .setAddress(entity.getAddress())
                              .setAdditionalAddress(entity.getAdditionalAddress())
                              .setCity(entity.getCity())
                              .setEmployees(entity.getEmployees()
                                                  .stream()
                                                  .map(OpticalWrapper::toDto)
                                                  .collect(toSet()))
                              .build();
    }

    public static OpticalStoreAddressDto toDto(OpticalStoreAddressView view) {
        return OpticalStoreAddressDto.builder()
                                     .setName(view.getName())
                                     .setAddress(view.getAddress())
                                     .setAdditionalAddress(view.getAdditionalAddress())
                                     .setCity(view.getCity())
                                     .build();
    }
}
