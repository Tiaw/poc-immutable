package poc.cyclops.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = OpticalStoreDto.Builder.class)
public class OpticalStoreDto {
    private Long id;
    private String name;
    private String address;
    private String additionalAddress;
    private String city;
    private Set<EmployeeDto> employees = new HashSet<>();

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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdditionalAddress() {
        return additionalAddress;
    }

    public void setAdditionalAddress(String additionalAddress) {
        this.additionalAddress = additionalAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeDto> employees) {
        this.employees = employees;
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

    /**
     * Creates builder to build {@link OpticalStoreDto}.
     * 
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder to build {@link OpticalStoreDto}.
     */
    public static final class Builder {
        private Long id;
        private String name;
        private String address;
        private String additionalAddress;
        private String city;
        private Set<EmployeeDto> employees = new HashSet<>();

        private Builder() {
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
            this.additionalAddress = additionalAddress;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withEmployee(EmployeeDto employee) {
            this.employees.add(employee);
            return this;
        }

        public Builder withEmployees(Set<EmployeeDto> employees) {
            this.employees.addAll(employees);
            return this;
        }

        public OpticalStoreDto build() {
            return new OpticalStoreDto(this);
        }
    }

}