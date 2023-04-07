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
    Optional<Cultivar> findByCodeEqualsIgnoreCase(String code);
    List<Cultivar> findAllByCodeIn(Collection<String> codes, Sort sort);
    List<Cultivar> findAllByCodeLikeIgnoreCase(String code, Sort sort);

    // Info searches
    <S extends Cultivar> Page<S> findAllByDescriptionLikeIgnoreCase(String description, Pageable pageable);

    // Search by hybrid
    <S extends Cultivar> Optional<S> findByHybridCodeEqualsIgnoreCase(String hybridCode);
    <S extends Cultivar> Optional<S> findByHybridCodeEqualsIgnoreCaseAndCodeLike(String hybridCode, String code);
    <S extends Cultivar> List<S> findByHybridCodeEqualsIgnoreCaseAndCodeIn(String hybridCode, Collection<String> codes, Pageable pageable);

    // Save and optionally flush
    @NonNull
    @Override
    <S extends Cultivar> S save(@NonNull S hybrid);
    @NonNull
    @Override
    <S extends Cultivar> S saveAndFlush(@NonNull S hybrid);
    @NonNull
    @Override
    <S extends Cultivar> List<S> saveAll(@NonNull Iterable<S> hybrids);
    @NonNull
    @Override
    <S extends Cultivar> List<S> saveAllAndFlush(@NonNull Iterable<S> hybrids);

    // Delete
    @Override
    void deleteById(@NonNull Long id);
    @Override
    void deleteAllById(@NonNull Iterable<? extends Long> ids);
}
