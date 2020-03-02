package poc.cyclops.dto;

import java.util.Set;

import org.immutables.value.Value;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@Value.Style(init = "with*", depluralize = true)
@JsonDeserialize(builder = ImmutableOpticalStoreDto.Builder.class)
public interface OpticalStoreDto {

    Long getId();

    String getName();

    String getAddress();

    @Nullable
    String getAdditionalAddress();

    String getCity();

    Set<EmployeeDto> getEmployees();

    public static ImmutableOpticalStoreDto.Builder builder() {
        return ImmutableOpticalStoreDto.builder();
    }

}