package poc.cyclops.wrapper;

import static java.util.stream.Collectors.toSet;

import poc.cyclops.domain.Employee;
import poc.cyclops.domain.OpticalStore;
import poc.cyclops.dto.EmployeeDto;
import poc.cyclops.dto.OpticalStoreDto;

public class OpticalWrapper {
    private OpticalWrapper() {
    }

    public static EmployeeDto toDto(Employee entity) {
        return EmployeeDto.builder()
                          .id(entity.getId())
                          .firstName(entity.getFirstName())
                          .lastName(entity.getLastName())
                          .build();
    }

    public static OpticalStoreDto toDto(OpticalStore entity) {
        return OpticalStoreDto.builder()
                              .id(entity.getId())
                              .name(entity.getName())
                              .address(entity.getAddress())
                              .additionalAddress(entity.getAdditionalAddress())
                              .city(entity.getCity())
                              .employees(entity.getEmployees()
                                               .stream()
                                               .map(OpticalWrapper::toDto)
                                               .collect(toSet()))
                              .build();
    }

}
