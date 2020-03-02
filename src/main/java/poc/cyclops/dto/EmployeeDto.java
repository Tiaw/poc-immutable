package poc.cyclops.dto;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.value.AutoValue;

@JsonDeserialize(builder = AutoValue_EmployeeDto.Builder.class)
@JsonSerialize(as = EmployeeDto.class)
@AutoValue
public abstract class EmployeeDto implements Serializable {
    private static final long serialVersionUID = 3330580419527461461L;

    public abstract Long getId();

    public abstract String getFirstName();

    public abstract String getLastName();

    public abstract int getAge();

    public static Builder builder() {
        return new AutoValue_EmployeeDto.Builder().setAge(0);
    }

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "set")
    public abstract static class Builder {
        public abstract Builder setId(Long id);

        public abstract Builder setFirstName(String firstName);

        public abstract Builder setLastName(String lastName);

        public abstract Builder setAge(int age);

        public abstract EmployeeDto build();
    }
}
