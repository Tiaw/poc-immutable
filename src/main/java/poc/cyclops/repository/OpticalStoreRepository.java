package poc.cyclops.repository;

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.FETCH;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.Repository;

import io.vavr.control.Option;
import poc.cyclops.domain.OpticalStore;

public interface OpticalStoreRepository extends Repository<OpticalStore, Long> {
    @EntityGraph(attributePaths = { "employees" }, type = FETCH)
    Option<OpticalStore> findById(Long id);

    @EntityGraph(attributePaths = { "employees" }, type = FETCH)
    <T> Stream<T> streamFetchEmployeesByName(String name, Class<T> type);

    <T> Stream<T> streamByName(String name, Class<T> type);

}
