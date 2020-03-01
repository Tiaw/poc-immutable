package poc.cyclops.dto;

import org.immutables.value.Value;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@Value.Style(init = "with*", of = "new", allParameters = true)
@JsonDeserialize(builder = ImmutableOpticalStoreAddressDto.Builder.class)
@JsonSerialize(as = ImmutableOpticalStoreAddressDto.class)
public abstract class OpticalStoreAddressDto {
    public abstract String getName();

    public abstract String getAddress();

    @Nullable
    public abstract String getAdditionalAddress();

    public abstract String getCity();

    public static ImmutableOpticalStoreAddressDto.Builder builder() {
        return ImmutableOpticalStoreAddressDto.builder();
    }

    public static ImmutableOpticalStoreAddressDto of(String name, String address, String additionalAddress,
            String city) {
        return new ImmutableOpticalStoreAddressDto(name, address, additionalAddress, city);
    }
}
