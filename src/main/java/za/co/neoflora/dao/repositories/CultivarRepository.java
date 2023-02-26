package za.co.neoflora.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.neoflora.dao.domain.Cultivar;

public interface CultivarRepository extends JpaRepository<Cultivar, Long> {

}
