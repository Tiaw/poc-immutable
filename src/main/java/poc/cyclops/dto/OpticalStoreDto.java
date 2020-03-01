package poc.cyclops.dto;

import java.util.Set;

import org.immutables.value.Value;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@Value.Style(init = "with*", depluralize = true)
@JsonDeserialize(builder = ImmutableOpticalStoreDto.Builder.class)
@JsonSerialize(as = ImmutableOpticalStoreDto.class)
public abstract class OpticalStoreDto {

    public abstract Long getId();

    public abstract String getName();

    public abstract String getAddress();

    @Nullable
    public abstract String getAdditionalAddress();

    public abstract String getCity();

    public abstract Set<EmployeeDto> getEmployees();

    public static ImmutableOpticalStoreDto.Builder builder() {
        return ImmutableOpticalStoreDto.builder();
    }

}