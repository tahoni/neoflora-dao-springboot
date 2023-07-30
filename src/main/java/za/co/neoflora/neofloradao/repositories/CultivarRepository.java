package za.co.neoflora.neofloradao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import za.co.neoflora.neofloradao.domain.Cultivar;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CultivarRepository extends JpaRepository<Cultivar, Long> {
    // Identity searches
    Optional<Cultivar> findByCodeEqualsIgnoreCase(String code);

    List<Cultivar> findAllByCodeIn(Collection<String> codes, Sort sort);

    List<Cultivar> findAllByCodeLikeIgnoreCase(String code, Sort sort);

    // Info searches
    <S extends Cultivar> Page<S> findAllByDescriptionLikeIgnoreCase(String description, Pageable pageable);

    // Search by hybrid
    <S extends Cultivar> Optional<S> findByHybridCodeEqualsIgnoreCase(String hybridCode);

    <S extends Cultivar> Optional<S> findByHybridCodeEqualsIgnoreCaseAndCodeLike(String hybridCode, String code);

    <S extends Cultivar> List<S> findByHybridCodeEqualsIgnoreCaseAndCodeIn(String hybridCode, Collection<String> codes,
            Pageable pageable);
}
