package poc.cyclops.repository;

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.FETCH;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poc.cyclops.domain.OpticalStore;

@Repository
public interface OpticalStoreRepository extends JpaRepository<OpticalStore, Long> {
    @Override
    @EntityGraph(attributePaths = { "employees" }, type = FETCH)
    Optional<OpticalStore> findById(Long id);

    @EntityGraph(attributePaths = { "employees" }, type = FETCH)
    <T> Stream<T> streamFetchEmployeesByName(String name, Class<T> type);

    <T> Stream<T> streamByName(String name, Class<T> type);

}
