package za.co.neoflora.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.neoflora.dao.domain.SeedTypeEntity;

public interface SeedTypeRepository extends JpaRepository<SeedTypeEntity, Long> {
}
