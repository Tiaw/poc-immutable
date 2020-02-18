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
        return new EmployeeDto(entity.getId(), entity.getFirstName(), entity.getLastName());
    }

    public static OpticalStoreDto toDto(OpticalStore entity) {
        OpticalStoreDto dto = new OpticalStoreDto(entity.getId(), entity.getName(), entity.getAddress(),
                entity.getAdditionalAddress(), entity.getCity());
        dto.setEmployees(entity.getEmployees().stream().map(OpticalWrapper::toDto).collect(toSet()));
        return dto;
    }

}
