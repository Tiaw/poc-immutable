package poc.cyclops.dto;

import org.immutables.value.Value;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@Value.Style(init = "with*")
@JsonDeserialize(builder = ImmutableOpticalStoreAddressDto.Builder.class)
public interface OpticalStoreAddressDto {
    String getName();

    String getAddress();

    @Nullable
    String getAdditionalAddress();

    String getCity();

    public static ImmutableOpticalStoreAddressDto.Builder builder() {
        return ImmutableOpticalStoreAddressDto.builder();
    }

}
