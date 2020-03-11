package poc.cyclops.dto;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.vavr.control.Option;

@JsonDeserialize(builder = OpticalStoreAddressDto.Builder.class)
public class OpticalStoreAddressDto {
    private String name;
    private String address;
    private Option<String> additionalAddress;
    private String city;

    public OpticalStoreAddressDto(String name, String address, String additionalAddress, String city) {
        super();
        this.name = name;
        this.address = address;
        this.additionalAddress = Option.of(additionalAddress);
        this.city = city;
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

    /**
     * Creates builder to build {@link OpticalStoreAddressDto}.
     * 
     * @return created builder
     */
    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        public AddressStage withName(String name);
    }

    public interface AddressStage {
        public BuildStage withAddress(String address);
    }

    public interface BuildStage {
        public BuildStage withAdditionalAddress(String additionalAddress);

        public BuildStage withCity(String city);

        public OpticalStoreAddressDto build();
    }

    /**
     * Builder to build {@link OpticalStoreAddressDto}.
     */
    public static final class Builder implements NameStage, AddressStage, BuildStage {
        private String name;
        private String address;
        private Option<String> additionalAddress = Option.none();
        private String city;

        private Builder() {
        }

        @Override
        public AddressStage withName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public BuildStage withAddress(String address) {
            this.address = address;
            return this;
        }

        @Override
        public BuildStage withAdditionalAddress(String additionalAddress) {
            this.additionalAddress = Option.of(additionalAddress);
            return this;
        }

        @Override
        public BuildStage withCity(String city) {
            this.city = city;
            return this;
        }

        @Override
        public OpticalStoreAddressDto build() {
            return new OpticalStoreAddressDto(name, address, additionalAddress.getOrNull(), city);
        }
    }

}
