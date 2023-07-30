package za.co.neoflora.neofloradao.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import za.co.neoflora.neofloradao.domain.OffspringType;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface OffspringTypeRepository extends JpaRepository<OffspringType, Long> {
    // Identity searches
    Optional<OffspringType> findByCodeEqualsIgnoreCase(String code);

    List<OffspringType> findAllByCodeIn(Collection<String> codes, Sort sort);

    List<OffspringType> findAllByCodeLikeIgnoreCase(String code, Sort sort);

    // Info searches
    List<OffspringType> findAllByTypeLikeIgnoreCase(String description, Sort sort);

    // Search by is default
    Optional<OffspringType> findByIsDefaultIsTrue();
}
