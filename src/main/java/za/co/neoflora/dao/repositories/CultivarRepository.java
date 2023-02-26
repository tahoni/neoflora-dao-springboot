package za.co.neoflora.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.neoflora.dao.domain.CultivarEntity;

public interface CultivarRepository extends JpaRepository<CultivarEntity, Long> {

}
