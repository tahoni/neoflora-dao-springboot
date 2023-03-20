package za.co.neoflora.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import za.co.neoflora.dao.domain.Photo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    // Key searches
    @NonNull
    @Override
    Optional<Photo> findById(@NonNull Long id);
    @NonNull
    @Override
    List<Photo> findAllById(@NonNull Iterable<Long> ids);
    @NonNull
    Page<Photo> findByIdIn(@NonNull Collection<Long> ids, @NonNull Pageable pageable);

    // Info searches
    List<Photo> findAllByDescriptionLikeIgnoreCase(String description, Sort sort);

    // Save and optionally flush
    @NonNull
    @Override
    <S extends Photo> S save(@NonNull S photo);
    @NonNull
    @Override
    <S extends Photo> S saveAndFlush(@NonNull S photo);
    @NonNull
    @Override
    <S extends Photo> List<S> saveAll(@NonNull Iterable<S> photos);
    @NonNull
    @Override
    <S extends Photo> List<S> saveAllAndFlush(@NonNull Iterable<S> photos);

    // Delete
    @Override
    void deleteById(@NonNull Long id);
    @Override
    void deleteAllById(@NonNull Iterable<? extends Long> ids);
}
