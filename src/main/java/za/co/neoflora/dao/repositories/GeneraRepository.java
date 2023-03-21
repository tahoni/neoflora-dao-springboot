package za.co.neoflora.dao.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import za.co.neoflora.dao.domain.Genera;

import java.util.List;
import java.util.Optional;

public interface GeneraRepository extends JpaRepository<Genera, Long> {
    // Key searches
    @NonNull
    @Override
    Optional<Genera> findById(@NonNull Long id);
    @NonNull
    @Override
    List<Genera> findAllById(@NonNull Iterable<Long> ids);
    @NonNull
    @Override
    List<Genera> findAll();

    // Identity searches
    Optional<Genera> findByCodeEqualsIgnoreCase(String code);
    List<Genera> findAllByCodeIn(List<String> codes, Sort sort);
    List<Genera> findAllByCodeLikeIgnoreCase(String code, Sort sort);

    // Info searches
    List<Genera> findAllByDescriptionLikeIgnoreCase(String description, Sort sort);

    // Save and optionally flush
    @NonNull
    @Override
    <S extends Genera> S save(@NonNull S genera);
    @NonNull
    @Override
    <S extends Genera> S saveAndFlush(@NonNull S genera);
    @NonNull
    @Override
    <S extends Genera> List<S> saveAll(@NonNull Iterable<S> genera);
    @NonNull
    @Override
    <S extends Genera> List<S> saveAllAndFlush(@NonNull Iterable<S> genera);

    // Delete
    @Override
    void deleteById(@NonNull Long id);
    @Override
    void deleteAllById(@NonNull Iterable<? extends Long> ids);
}
