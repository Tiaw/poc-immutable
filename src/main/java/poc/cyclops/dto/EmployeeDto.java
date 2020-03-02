package poc.cyclops.dto;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@Value.Style(init = "with*")
@JsonDeserialize(builder = ImmutableEmployeeDto.Builder.class)
public interface EmployeeDto {

    Long getId();

    String getFirstName();

    String getLastName();

    default int getAge() {
        return 0;
    }

    public static ImmutableEmployeeDto.Builder builder() {
        return ImmutableEmployeeDto.builder();
    }
}
