package za.co.neoflora.neofloradao.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import za.co.neoflora.neofloradao.domain.Photo;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    // Info searches
    List<Photo> findAllByDescriptionLikeIgnoreCase(String description, Sort sort);
}
