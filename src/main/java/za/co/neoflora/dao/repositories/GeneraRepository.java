package za.co.neoflora.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.neoflora.dao.domain.Genera;

public interface GeneraRepository extends JpaRepository<Genera, Long> {
}
