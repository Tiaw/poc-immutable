package poc.cyclops.webservice;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import poc.cyclops.dto.OpticalStoreDto;

@Path("/store")
public interface OpticalStoreWebService {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<OpticalStoreDto> findById(@PathParam("id") Long id);

    @GET
    @Path("/notoptional/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public OpticalStoreDto findByIdNotOptional(@PathParam("id") Long id);

    @GET
    @Path("/find/byName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OpticalStoreDto> findByName(@PathParam("name") String name);

}
