package za.co.neoflora.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import za.co.neoflora.dao.domain.Cultivar;

import java.util.Collection;
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
    @NonNull
    @Override
    Page<Cultivar> findAll(@NonNull Pageable pageable);
    @NonNull
    Page<Cultivar> findByIdIn(@NonNull Collection<Long> ids, Pageable pageable);

    // Identity searches
    Optional<Cultivar> findByCodeEquals(String code);
    List<Cultivar> findAllByCodeIn(List<String> codes, Sort sort);
    List<Cultivar> findAllByCodeLike(String code, Sort sort);

    // Info searches
    <S extends Cultivar> Page<S> findAllByDescriptionLikeIgnoreCase(String description, Pageable pageable);

    // Search by genera
    <S extends Cultivar> Page<S> findAllByGeneraCodeEqualsIgnoreCase(String generaCode, Pageable pageable);
    <S extends Cultivar> Page<S> findAllByGeneraCodeEqualsIgnoreCaseAndCodeLike(String generaCode, String code, Pageable pageable);
    <S extends Cultivar> Page<S> findAllByGeneraCodeEqualsIgnoreCaseAndCodeIn(String generaCode, List<String> codes, Pageable pageable);

    // Search by mother and/or father
    <S extends Cultivar> Page<S> findAllByMotherCodeEqualsIgnoreCase(String motherCode, Pageable pageable);
    <S extends Cultivar> Page<S> findAllByFatherCodeEqualsIgnoreCase(String fatherCode, Pageable pageable);
    <S extends Cultivar> Page<S> findAllByMotherCodeEqualsIgnoreCaseAndFatherCodeEqualsIgnoreCase(String motherCode, String fatherCode, Pageable pageable);
    <S extends Cultivar> Page<S> findAllByMotherCodeEqualsIgnoreCaseOrFatherCodeEqualsIgnoreCase(String motherCode, String fatherCode, Pageable pageable);

    // Save and optionally flush
    @NonNull
    @Override
    <S extends Cultivar> S save(@NonNull S cultivar);
    @NonNull
    @Override
    <S extends Cultivar> S saveAndFlush(@NonNull S cultivar);
    @NonNull
    @Override
    <S extends Cultivar> List<S> saveAll(@NonNull Iterable<S> cultivars);
    @NonNull
    @Override
    <S extends Cultivar> List<S> saveAllAndFlush(@NonNull Iterable<S> cultivars);

    // Delete
    @Override
    void deleteById(@NonNull Long id);
    @Override
    void deleteAllById(@NonNull Iterable<? extends Long> ids);
}
