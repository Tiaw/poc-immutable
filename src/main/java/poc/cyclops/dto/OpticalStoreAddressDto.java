package poc.cyclops.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OpticalStoreAddressDto {
    private String name;
    private String address;
    private String additionalAddress;
    private String city;

    @JsonCreator(mode = Mode.PROPERTIES)
    public OpticalStoreAddressDto(@JsonProperty("name") String name,
            @JsonProperty("address") String address,
            @JsonProperty("additionalAddress") String additionalAddress,
            @JsonProperty("city") String city) {
        this.name = name;
        this.address = address;
        this.additionalAddress = additionalAddress;
        this.city = city;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OpticalStoreAdresseDto [name=")
               .append(name)
               .append(", address=")
               .append(address)
               .append(", additionalAddress=")
               .append(additionalAddress)
               .append(", city=")
               .append(city)
               .append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalAddress, address, city, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OpticalStoreAddressDto other = (OpticalStoreAddressDto) obj;
        return Objects.equals(additionalAddress, other.additionalAddress) && Objects.equals(address, other.address)
                && Objects.equals(city, other.city) && Objects.equals(name, other.name);
    }

}
