package poc.cyclops.webservice;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.vavr.collection.Seq;
import io.vavr.control.Option;
import poc.cyclops.dto.OpticalStoreAddressDto;
import poc.cyclops.dto.OpticalStoreDto;

@Path("/store")
public interface OpticalStoreWebService {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Option<OpticalStoreDto> findById(@PathParam("id") Long id);

    @GET
    @Path("/notoptional/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    OpticalStoreDto findByIdNotOptional(@PathParam("id") Long id);

    @GET
    @Path("/find/byName")
    @Produces(MediaType.APPLICATION_JSON)
    Seq<OpticalStoreDto> findByName(@NotNull(message = "Le nom est requis") @QueryParam("name") String name);

    @GET
    @Path("/find/address/byName")
    @Produces(MediaType.APPLICATION_JSON)
    Seq<OpticalStoreAddressDto> findAddressByName(
            @NotNull(message = "Le nom est requis") @QueryParam("name") String name);

}
