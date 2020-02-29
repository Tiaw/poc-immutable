package poc.cyclops.dto;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = EmployeeDto.EmployeeDtoBuilder.class)
public class EmployeeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    @JsonPOJOBuilder(withPrefix = "")
    public static class EmployeeDtoBuilder {

    }
}
