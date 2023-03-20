package za.co.neoflora.dao.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import za.co.neoflora.dao.domain.Photo;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    // Info searches
    List<Photo> findAllByDescriptionLikeIgnoreCase(String description, Sort sort);
}
