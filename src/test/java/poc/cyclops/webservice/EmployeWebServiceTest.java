package poc.cyclops.webservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;

import javax.ws.rs.BadRequestException;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.assertj.vavr.api.VavrAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import io.vavr.collection.Seq;
import io.vavr.control.Option;
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
                                                  .addEmployee(EmployeeDto.builder()
                                                                          .withId(1L)
                                                                          .withFirstName("Jean")
                                                                          .withLastName("Moulin")
                                                                          .build())
                                                  .addEmployee(EmployeeDto.builder()
                                                                          .withId(2L)
                                                                          .withFirstName("Bob")
                                                                          .withLastName("Morane")
                                                                          .build())
                                                  .build();
        Option<OpticalStoreDto> actual = opticalStoreWebService.findById(1L);
        assertThat(actual.toJavaOptional()).get()
                                           .usingRecursiveComparison()
                                           .ignoringAllOverriddenEquals()
                                           .ignoringCollectionOrder()
                                           .isEqualTo(expected);
    }

    @Test
    public void shouldFindByIdEmpty() {
        Option<OpticalStoreDto> actual = opticalStoreWebService.findById(0L);
        VavrAssertions.assertThat(actual).isEmpty();
    }

    @Test
    public void shouldFindByIdNotOptional() {
        OpticalStoreDto expected = OpticalStoreDto.builder()
                                                  .withId(1L)
                                                  .withName("Optical center")
                                                  .withAddress("15 rue du haut")
                                                  .withCity("Nantes")
                                                  .addEmployee(EmployeeDto.builder()
                                                                          .withId(1L)
                                                                          .withFirstName("Jean")
                                                                          .withLastName("Moulin")
                                                                          .build())
                                                  .addEmployee(EmployeeDto.builder()
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
    public void shouldFailFindByNameWithoutQueryParams() {
        BadRequestException exception = Assertions.assertThrows(BadRequestException.class,
                () -> opticalStoreWebService.findByName(null));
        assertThat(exception).hasMessage("blablabla");
    }

    @Test
    public void shouldFindByName() {
        OpticalStoreDto expected = OpticalStoreDto.builder()
                                                  .withId(1L)
                                                  .withName("Optical center")
                                                  .withAddress("15 rue du haut")
                                                  .withCity("Nantes")
                                                  .addEmployee(EmployeeDto.builder()
                                                                          .withId(1L)
                                                                          .withFirstName("Jean")
                                                                          .withLastName("Moulin")
                                                                          .build())
                                                  .addEmployee(EmployeeDto.builder()
                                                                          .withId(2L)
                                                                          .withFirstName("Bob")
                                                                          .withLastName("Morane")
                                                                          .build())
                                                  .build();
        Seq<OpticalStoreDto> actual = opticalStoreWebService.findByName("Optical center");
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
        Seq<OpticalStoreAddressDto> actual = opticalStoreWebService.findAddressByName("Optical center");
        assertThat(actual).usingRecursiveComparison()
                          .ignoringAllOverriddenEquals()
                          .ignoringCollectionOrder()
                          .isEqualTo(Collections.singletonList(expected));
    }

    @Test
    public void shouldFindAddressByName2() {
        OpticalStoreAddressDto expected = new OpticalStoreAddressDto("Optical center", "15 rue du haut", null,
                "Nantes");
        Seq<OpticalStoreAddressDto> actual = opticalStoreWebService.findAddressByName("Optical center");
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

    @Test
    public void shouldUpdateAdditionalAddressOfOpticalStore() {
        Option<OpticalStoreDto> actual = opticalStoreWebService.findById(1L);
        Option<OpticalStoreDto> updated = actual.map(
                o -> o.draft().withAdditionalAddress("An additional Address").build());

        assertThat(actual).usingRecursiveComparison()
                          .ignoringFields("additionalAddress")
                          .ignoringAllOverriddenEquals()
                          .ignoringCollectionOrder()
                          .isEqualTo(updated);
    }

}
