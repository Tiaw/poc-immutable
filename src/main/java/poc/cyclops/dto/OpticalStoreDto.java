package poc.cyclops.dto;

import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = OpticalStoreDto.OpticalStoreDtoBuilder.class)
public class OpticalStoreDto {
    private Long id;
    private String name;
    private String address;
    private String additionalAddress;
    private String city;
    @Singular
    private Set<EmployeeDto> employees;

    @JsonPOJOBuilder(withPrefix = "")
    public static class OpticalStoreDtoBuilder {

    }
}