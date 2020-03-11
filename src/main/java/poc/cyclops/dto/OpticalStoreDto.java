package poc.cyclops.dto;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.vavr.collection.Seq;
import io.vavr.collection.Vector;
import io.vavr.control.Option;

@JsonDeserialize(builder = OpticalStoreDto.Builder.class)
public class OpticalStoreDto {
    private Long id;
    private String name;
    private String address;
    private Option<String> additionalAddress;
    private String city;
    private Seq<EmployeeDto> employees;

    private OpticalStoreDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.additionalAddress = builder.additionalAddress;
        this.city = builder.city;
        this.employees = builder.employees;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Option<String> getAdditionalAddress() {
        return additionalAddress;
    }

    public String getCity() {
        return city;
    }

    public Seq<EmployeeDto> getEmployees() {
        return employees;
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalAddress, address, city, employees, id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OpticalStoreDto other = (OpticalStoreDto) obj;
        return Objects.equals(additionalAddress, other.additionalAddress) && Objects.equals(address, other.address)
                && Objects.equals(city, other.city) && Objects.equals(employees, other.employees)
                && Objects.equals(id, other.id) && Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OpticalStoreDto [id=")
               .append(id)
               .append(", name=")
               .append(name)
               .append(", address=")
               .append(address)
               .append(", additionalAddress=")
               .append(additionalAddress)
               .append(", city=")
               .append(city)
               .append(", employees=")
               .append(employees)
               .append("]");
        return builder.toString();
    }

    public Builder draft() {
        return new Builder(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Creates a builder to build {@link OpticalStoreDto} and initialize it with the
     * given object.
     * 
     * @param opticalStoreDto to initialize the builder with
     * @return created builder
     */
    public static Builder builderFrom(OpticalStoreDto opticalStoreDto) {
        return new Builder(opticalStoreDto);
    }

    /**
     * Builder to build {@link OpticalStoreDto}.
     */
    public static final class Builder {
        private Long id;
        private String name;
        private String address;
        private Option<String> additionalAddress = Option.none();
        private String city;
        private Seq<EmployeeDto> employees = Vector.empty();

        private Builder() {
        }

        private Builder(OpticalStoreDto opticalStoreDto) {
            this.id = opticalStoreDto.id;
            this.name = opticalStoreDto.name;
            this.address = opticalStoreDto.address;
            this.additionalAddress = opticalStoreDto.additionalAddress;
            this.city = opticalStoreDto.city;
            this.employees = opticalStoreDto.employees;
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withAdditionalAddress(String additionalAddress) {
            this.additionalAddress = Option.of(additionalAddress);
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder addEmployee(EmployeeDto employee) {
            this.employees = this.employees.append(employee);
            return this;
        }

        public Builder addAllEmployees(Iterable<EmployeeDto> employees) {
            this.employees = this.employees.appendAll(employees);
            return this;
        }

        public Builder withEmployees(Iterable<EmployeeDto> employees) {
            this.employees = Vector.ofAll(employees);
            return this;
        }

        public OpticalStoreDto build() {
            return new OpticalStoreDto(this);
        }
    }

}