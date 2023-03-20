package za.co.neoflora.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.neoflora.dao.domain.SeedType;

import java.util.List;
import java.util.Optional;

public interface SeedTypeRepository extends JpaRepository<SeedType, Long> {
    // Identity searches
    Optional<SeedType> findByCodeEqualsIgnoreCase(String code);
    List<SeedType> findAllByCodeIn(List<String> codes);
    List<SeedType> findAllByCodeLikeIgnoreCase(String code);

    // Info searches
    List<SeedType> findAllByTypeLikeIgnoreCase(String description);

    // Search by is default
    Optional<SeedType> findByIsDefaultIsTrue();
}
