package poc.cyclops.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
@JsonDeserialize(builder = OpticalStoreAddressDto.OpticalStoreAddressDtoBuilder.class)
public class OpticalStoreAddressDto {
    private String name;
    private String address;
    private String additionalAddress;
    private String city;

    @JsonPOJOBuilder(withPrefix = "")
    public static class OpticalStoreAddressDtoBuilder {

    }
}
