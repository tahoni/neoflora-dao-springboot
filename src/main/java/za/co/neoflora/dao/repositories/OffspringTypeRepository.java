package za.co.neoflora.dao.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import za.co.neoflora.dao.domain.OffspringType;

import java.util.List;
import java.util.Optional;

public interface OffspringTypeRepository extends JpaRepository<OffspringType, Long> {
    // Key searches
    @NonNull
    @Override
    Optional<OffspringType> findById(@NonNull Long id);
    @NonNull
    @Override
    List<OffspringType> findAllById(@NonNull Iterable<Long> ids);
    @NonNull
    @Override
    List<OffspringType> findAll();

    // Identity searches
    Optional<OffspringType> findByCodeEqualsIgnoreCase(String code);
    List<OffspringType> findAllByCodeIn(List<String> codes, Sort sort);
    List<OffspringType> findAllByCodeLikeIgnoreCase(String code, Sort sort);

    // Info searches
    List<OffspringType> findAllByTypeLikeIgnoreCase(String description, Sort sort);

    // Search by is default
    Optional<OffspringType> findByIsDefaultIsTrue();
}
