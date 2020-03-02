package poc.cyclops.dto;

import java.util.Set;

import javax.annotation.Nullable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;

@JsonDeserialize(builder = AutoValue_OpticalStoreDto.Builder.class)
@JsonSerialize(as = OpticalStoreDto.class)
@AutoValue
public abstract class OpticalStoreDto {

    public abstract Long getId();

    public abstract String getName();

    public abstract String getAddress();

    @Nullable
    public abstract String getAdditionalAddress();

    public abstract String getCity();

    public abstract ImmutableSet<EmployeeDto> getEmployees();

    public static Builder builder() {
        return new AutoValue_OpticalStoreDto.Builder();
    }

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "set")
    public abstract static class Builder {

        public abstract Builder setId(Long id);

        public abstract Builder setName(String name);

        public abstract Builder setAddress(String address);

        public abstract Builder setAdditionalAddress(String additionalAddress);

        public abstract Builder setCity(String city);

        public abstract Builder setEmployees(Set<EmployeeDto> employees);

        abstract ImmutableSet.Builder<EmployeeDto> employeesBuilder();

        public Builder addEmployee(EmployeeDto employee) {
            employeesBuilder().add(employee);
            return this;
        }

        public abstract OpticalStoreDto build();
    }

}