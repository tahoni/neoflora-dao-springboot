package za.co.neoflora.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.neoflora.dao.domain.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
