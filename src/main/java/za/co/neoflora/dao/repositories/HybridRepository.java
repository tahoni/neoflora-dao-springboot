package za.co.neoflora.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import za.co.neoflora.dao.domain.Hybrid;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface HybridRepository extends JpaRepository<Hybrid, Long> {
    // Key searches
    @NonNull
    @Override
    Optional<Hybrid> findById(@NonNull Long id);
    @NonNull
    @Override
    List<Hybrid> findAllById(@NonNull Iterable<Long> ids);
    @NonNull
    @Override
    Page<Hybrid> findAll(@NonNull Pageable pageable);
    @NonNull
    Page<Hybrid> findByIdIn(@NonNull Collection<Long> ids, Pageable pageable);

    // Identity searches
    Optional<Hybrid> findByCodeEquals(String code);
    List<Hybrid> findAllByCodeIn(List<String> codes, Sort sort);
    List<Hybrid> findAllByCodeLike(String code, Sort sort);

    // Info searches
    <S extends Hybrid> Page<S> findAllByDescriptionLikeIgnoreCase(String description, Pageable pageable);

    // Search by genera
    <S extends Hybrid> Page<S> findAllByGeneraCodeEqualsIgnoreCase(String generaCode, Pageable pageable);
    <S extends Hybrid> Page<S> findAllByGeneraCodeEqualsIgnoreCaseAndCodeLike(String generaCode, String code, Pageable pageable);
    <S extends Hybrid> Page<S> findAllByGeneraCodeEqualsIgnoreCaseAndCodeIn(String generaCode, List<String> codes, Pageable pageable);

    // Search by mother and/or father
    <S extends Hybrid> Page<S> findAllByMotherCodeEqualsIgnoreCase(String motherCode, Pageable pageable);
    <S extends Hybrid> Page<S> findAllByFatherCodeEqualsIgnoreCase(String fatherCode, Pageable pageable);
    <S extends Hybrid> Page<S> findAllByMotherCodeEqualsIgnoreCaseAndFatherCodeEqualsIgnoreCase(String motherCode, String fatherCode, Pageable pageable);
    <S extends Hybrid> Page<S> findAllByMotherCodeEqualsIgnoreCaseOrFatherCodeEqualsIgnoreCase(String motherCode, String fatherCode, Pageable pageable);

    // Save and optionally flush
    @NonNull
    @Override
    <S extends Hybrid> S save(@NonNull S hybrid);
    @NonNull
    @Override
    <S extends Hybrid> S saveAndFlush(@NonNull S hybrid);
    @NonNull
    @Override
    <S extends Hybrid> List<S> saveAll(@NonNull Iterable<S> hybrids);
    @NonNull
    @Override
    <S extends Hybrid> List<S> saveAllAndFlush(@NonNull Iterable<S> hybrids);

    // Delete
    @Override
    void deleteById(@NonNull Long id);
    @Override
    void deleteAllById(@NonNull Iterable<? extends Long> ids);
}
