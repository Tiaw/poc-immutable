package poc.cyclops.dto;

import javax.annotation.Nullable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.value.AutoValue;

@JsonDeserialize(builder = AutoValue_OpticalStoreAddressDto.Builder.class)
@JsonSerialize(as = OpticalStoreAddressDto.class)
@AutoValue
public abstract class OpticalStoreAddressDto {
    public abstract String getName();

    public abstract String getAddress();

    @Nullable
    public abstract String getAdditionalAddress();

    public abstract String getCity();

    public static OpticalStoreAddressDto of(String name, String address, String additionalAddress, String city) {
        return new AutoValue_OpticalStoreAddressDto.Builder().setName(name)
                                                             .setAddress(address)
                                                             .setAdditionalAddress(additionalAddress)
                                                             .setCity(city)
                                                             .build();
    }

    public static Builder builder() {
        return new AutoValue_OpticalStoreAddressDto.Builder();
    }

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "set")
    public abstract static class Builder {
        public abstract Builder setName(String name);

        public abstract Builder setAddress(String address);

        public abstract Builder setAdditionalAddress(String additionalAddress);

        public abstract Builder setCity(String city);

        public abstract OpticalStoreAddressDto build();
    }

}
