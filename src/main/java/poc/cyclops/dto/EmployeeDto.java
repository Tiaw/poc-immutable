package poc.cyclops.dto;

import java.io.Serializable;

import org.immutables.value.Value;
import org.immutables.value.Value.Default;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@Value.Style(init = "with*")
@JsonDeserialize(builder = ImmutableEmployeeDto.Builder.class)
@JsonSerialize(as = ImmutableEmployeeDto.class)
public abstract class EmployeeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract Long getId();

    public abstract String getFirstName();

    public abstract String getLastName();

    @Default
    public int getAge() {
        return 0;
    }

    public static ImmutableEmployeeDto.Builder builder() {
        return ImmutableEmployeeDto.builder();
    }
}
