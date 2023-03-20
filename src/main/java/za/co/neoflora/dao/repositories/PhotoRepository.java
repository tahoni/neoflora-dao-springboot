package za.co.neoflora.dao.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import za.co.neoflora.dao.domain.Photo;

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

    // Info searches
    List<Photo> findAllByDescriptionLikeIgnoreCase(String description, Sort sort);
}
