package za.co.neoflora.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.neoflora.dao.domain.PhotoEntity;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {
}
