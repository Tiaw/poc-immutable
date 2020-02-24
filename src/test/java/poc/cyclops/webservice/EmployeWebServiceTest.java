package poc.cyclops.webservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import poc.cyclops.config.NiceJsonProvider;
import poc.cyclops.dto.EmployeeDto;
import poc.cyclops.dto.OpticalStoreAddressDto;
import poc.cyclops.dto.OpticalStoreDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeWebServiceTest {

    private OpticalStoreWebService opticalStoreWebService;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        opticalStoreWebService = JAXRSClientFactory.create(url(), OpticalStoreWebService.class,
                Arrays.asList(new NiceJsonProvider()), true);
    }

    private String url() {
        return "http://localhost:"
                + port
                + "/services";
    }

    @Test
    public void shouldFindById() {
        OpticalStoreDto expected = OpticalStoreDto.builder()
                                                  .withId(1L)
                                                  .withName("Optical center")
                                                  .withAddress("15 rue du haut")
                                                  .withCity("Nantes")
                                                  .withEmployee(EmployeeDto.builder()
                                                                           .withId(1L)
                                                                           .withFirstName("Jean")
                                                                           .withLastName("Moulin")
                                                                           .build())
                                                  .withEmployee(EmployeeDto.builder()
                                                                           .withId(2L)
                                                                           .withFirstName("Bob")
                                                                           .withLastName("Morane")
                                                                           .build())
                                                  .build();
        Optional<OpticalStoreDto> actual = opticalStoreWebService.findById(1L);
        assertThat(actual).get()
                          .usingRecursiveComparison()
                          .ignoringAllOverriddenEquals()
                          .ignoringCollectionOrder()
                          .isEqualTo(expected);
    }

    @Test
    public void shouldFindByIdEmpty() {
        Optional<OpticalStoreDto> actual = opticalStoreWebService.findById(0L);
        assertThat(actual).isEmpty();
    }

    @Test
    public void shouldFindByIdNotOptional() {
        OpticalStoreDto expected = OpticalStoreDto.builder()
                                                  .withId(1L)
                                                  .withName("Optical center")
                                                  .withAddress("15 rue du haut")
                                                  .withCity("Nantes")
                                                  .withEmployee(EmployeeDto.builder()
                                                                           .withId(1L)
                                                                           .withFirstName("Jean")
                                                                           .withLastName("Moulin")
                                                                           .build())
                                                  .withEmployee(EmployeeDto.builder()
                                                                           .withId(2L)
                                                                           .withFirstName("Bob")
                                                                           .withLastName("Morane")
                                                                           .build())
                                                  .build();
        OpticalStoreDto actual = opticalStoreWebService.findByIdNotOptional(1L);
        assertThat(actual).usingRecursiveComparison()
                          .ignoringAllOverriddenEquals()
                          .ignoringCollectionOrder()
                          .isEqualTo(expected);
    }

    @Test
    public void shouldFindByName() {
        OpticalStoreDto expected = OpticalStoreDto.builder()
                                                  .withId(1L)
                                                  .withName("Optical center")
                                                  .withAddress("15 rue du haut")
                                                  .withCity("Nantes")
                                                  .withEmployee(EmployeeDto.builder()
                                                                           .withId(1L)
                                                                           .withFirstName("Jean")
                                                                           .withLastName("Moulin")
                                                                           .build())
                                                  .withEmployee(EmployeeDto.builder()
                                                                           .withId(2L)
                                                                           .withFirstName("Bob")
                                                                           .withLastName("Morane")
                                                                           .build())
                                                  .build();
        List<OpticalStoreDto> actual = opticalStoreWebService.findByName("Optical center");
        assertThat(actual).usingRecursiveComparison()
                          .ignoringAllOverriddenEquals()
                          .ignoringCollectionOrder()
                          .isEqualTo(Collections.singletonList(expected));
    }

    @Test
    public void shouldFindAddressByName() {
        OpticalStoreAddressDto expected = OpticalStoreAddressDto.builder()
                                                                .withName("Optical center")
                                                                .withAddress("15 rue du haut")
                                                                .withCity("Nantes")
                                                                .build();
        List<OpticalStoreAddressDto> actual = opticalStoreWebService.findAddressByName("Optical center");
        assertThat(actual).usingRecursiveComparison()
                          .ignoringAllOverriddenEquals()
                          .ignoringCollectionOrder()
                          .isEqualTo(Collections.singletonList(expected));
    }

    @Test
    public void shouldFindByIdNotOptionalEmpty() {
        OpticalStoreDto actual = opticalStoreWebService.findByIdNotOptional(0L);
        assertThat(actual).isNull();
    }
}
