package poc.cyclops.webservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        OpticalStoreDto expected = new OpticalStoreDto(1L, "Optical center", "15 rue du haut", null, "Nantes");
        Set<EmployeeDto> employees = new HashSet<>();
        employees.add(new EmployeeDto(1L, "Jean", "Moulin"));
        employees.add(new EmployeeDto(2L, "Bob", "Morane"));
        expected.setEmployees(employees);
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
        OpticalStoreDto expected = new OpticalStoreDto(1L, "Optical center", "15 rue du haut", null, "Nantes");
        Set<EmployeeDto> employees = new HashSet<>();
        employees.add(new EmployeeDto(1L, "Jean", "Moulin"));
        employees.add(new EmployeeDto(2L, "Bob", "Morane"));
        expected.setEmployees(employees);
        OpticalStoreDto actual = opticalStoreWebService.findByIdNotOptional(1L);
        assertThat(actual).usingRecursiveComparison()
                          .ignoringAllOverriddenEquals()
                          .ignoringCollectionOrder()
                          .isEqualTo(expected);
    }

    @Test
    public void shouldFindByName() {
        OpticalStoreDto expected = new OpticalStoreDto(1L, "Optical center", "15 rue du haut", null, "Nantes");
        Set<EmployeeDto> employees = new HashSet<>();
        employees.add(new EmployeeDto(1L, "Jean", "Moulin"));
        employees.add(new EmployeeDto(2L, "Bob", "Morane"));
        expected.setEmployees(employees);
        List<OpticalStoreDto> actual = opticalStoreWebService.findByName("Optical center");
        assertThat(actual).usingRecursiveComparison()
                          .ignoringAllOverriddenEquals()
                          .ignoringCollectionOrder()
                          .isEqualTo(Collections.singletonList(expected));
    }

    @Test
    public void shouldFindAddressByName() {
        OpticalStoreAddressDto expected = new OpticalStoreAddressDto("Optical center", "15 rue du haut", null,
                "Nantes");
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
