package poc.cyclops.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class OpticalStoreDto {
    private Long id;
    private String name;
    private String address;
    private String additionalAddress;
    private String city;
    private Set<EmployeeDto> employees = new HashSet<>();

    public OpticalStoreDto() {
    }

    public OpticalStoreDto(Long id, String name, String address, String additionalAddress, String city) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.additionalAddress = additionalAddress;
        this.city = city;
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

}
