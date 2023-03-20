package za.co.neoflora.dao.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import za.co.neoflora.dao.domain.Genera;

import java.util.List;
import java.util.Optional;

public interface GeneraRepository extends JpaRepository<Genera, Long> {
    // Identity searches
    Optional<Genera> findByCodeEqualsIgnoreCase(String code);
    List<Genera> findAllByCodeIn(List<String> codes, Sort sort);
    List<Genera> findAllByCodeLikeIgnoreCase(String code, Sort sort);

    // Info searches
    List<Genera> findAllByDescriptionLikeIgnoreCase(String description, Sort sort);
}
