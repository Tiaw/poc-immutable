package poc.cyclops.repository;

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.FETCH;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poc.cyclops.domain.OpticalStore;
import poc.cyclops.dto.OpticalStoreAddressDto;

@Repository
public interface OpticalStoreRepository extends JpaRepository<OpticalStore, Long> {
    @Override
    @EntityGraph(attributePaths = { "employees" }, type = FETCH)
    Optional<OpticalStore> findById(Long id);

    @EntityGraph(attributePaths = { "employees" }, type = FETCH)
    <T> Stream<T> streamFetchEmployeesByName(String name, Class<T> type);

    @Query("select new poc.cyclops.dto.ImmutableOpticalStoreAddressDto(o.name, o.address, o.additionalAddress, o.city) from OpticalStore o where o.name = ?1")
    Stream<OpticalStoreAddressDto> streamByName(String name);

}
