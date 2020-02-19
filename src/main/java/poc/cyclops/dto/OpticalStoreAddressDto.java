package poc.cyclops.dto;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import poc.cyclops.dto.OpticalStoreAddressDto.OpticalStoreAddressDtoBuilder;

@JsonDeserialize(builder = OpticalStoreAddressDtoBuilder.class)
public class OpticalStoreAddressDto {
    private String name;
    private String address;
    private String additionalAddress;
    private String city;

    public OpticalStoreAddressDto(String name,
            String address,
            String additionalAddress,
            String city) {
        this.name = name;
        this.address = address;
        this.additionalAddress = additionalAddress;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getAdditionalAddress() {
        return additionalAddress;
    }

    public String getCity() {
        return city;
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

    @JsonPOJOBuilder(withPrefix = "")
    public static class OpticalStoreAddressDtoBuilder {
        private String name;
        private String address;
        private String additionalAddress;
        private String city;

        public OpticalStoreAddressDto build() {
            return new OpticalStoreAddressDto(name, address, additionalAddress, city);
        }

        public OpticalStoreAddressDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public OpticalStoreAddressDtoBuilder address(String address) {
            this.address = address;
            return this;
        }

        public OpticalStoreAddressDtoBuilder additionalAddress(String additionalAddress) {
            this.additionalAddress = additionalAddress;
            return this;
        }

        public OpticalStoreAddressDtoBuilder city(String city) {
            this.city = city;
            return this;
        }

    }
}
