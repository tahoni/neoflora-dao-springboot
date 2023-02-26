package za.co.neoflora.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.neoflora.dao.domain.OffspringTypeEntity;

public interface OffspringTypeRepository extends JpaRepository<OffspringTypeEntity, Long> {
}
