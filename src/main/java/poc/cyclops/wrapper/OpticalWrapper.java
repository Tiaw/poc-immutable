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
                          .withId(entity.getId())
                          .withFirstName(entity.getFirstName())
                          .withLastName(entity.getLastName())
                          .build();
    }

    public static OpticalStoreDto toDto(OpticalStore entity) {
        return OpticalStoreDto.builder()
                              .withId(entity.getId())
                              .withName(entity.getName())
                              .withAddress(entity.getAddress())
                              .withAdditionalAddress(entity.getAdditionalAddress())
                              .withCity(entity.getCity())
                              .withEmployees(entity.getEmployees()
                                                   .stream()
                                                   .map(OpticalWrapper::toDto)
                                                   .collect(toSet()))
                              .build();
    }

}
