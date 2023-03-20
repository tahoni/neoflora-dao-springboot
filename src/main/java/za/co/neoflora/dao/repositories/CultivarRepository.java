package za.co.neoflora.dao.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import za.co.neoflora.dao.domain.Cultivar;

import java.util.List;
import java.util.Optional;

public interface CultivarRepository extends JpaRepository<Cultivar, Long> {
    // Key searches
    @NonNull
    @Override
    Optional<Cultivar> findById(@NonNull Long id);
    @NonNull
    @Override
    List<Cultivar> findAllById(@NonNull Iterable<Long> ids);

    // Identity searches
    Optional<Cultivar> findByCodeEquals(String code);
    List<Cultivar> findAllByCodeIn(List<String> codes, Sort sort);
    List<Cultivar> findAllByCodeLike(String code, Sort sort);

    // Info searches
    List<Cultivar> findAllByDescriptionLikeIgnoreCase(String description, Sort sort);

    // Search by genera
    List<Cultivar> findAllByGeneraCodeEqualsIgnoreCase(String generaCode, Sort sort);
    List<Cultivar> findAllByGeneraCodeEqualsIgnoreCaseAndCodeLike(String generaCode, String code, Sort sort);
    List<Cultivar> findAllByGeneraCodeEqualsIgnoreCaseAndCodeIn(String generaCode, List<String> codes, Sort sort);

    // Search by mother and/or father
    List<Cultivar> findAllByMotherCodeEqualsIgnoreCase(String motherCode, Sort sort);
    List<Cultivar> findAllByFatherCodeEqualsIgnoreCase(String fatherCode, Sort sort);
    List<Cultivar> findAllByMotherCodeEqualsIgnoreCaseAndFatherCodeEqualsIgnoreCase(String motherCode, String fatherCode, Sort sort);
    List<Cultivar> findAllByMotherCodeEqualsIgnoreCaseOrFatherCodeEqualsIgnoreCase(String motherCode, String fatherCode, Sort sort);
}
