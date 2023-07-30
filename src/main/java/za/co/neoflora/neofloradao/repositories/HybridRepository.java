package za.co.neoflora.neofloradao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import za.co.neoflora.neofloradao.domain.Hybrid;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface HybridRepository extends JpaRepository<Hybrid, Long> {
    // Identity searches
    Optional<Hybrid> findByCodeEqualsIgnoreCase(String code);

    List<Hybrid> findAllByCodeIn(Collection<String> codes, Sort sort);

    List<Hybrid> findAllByCodeLikeIgnoreCase(String code, Sort sort);

    // Info searches
    <S extends Hybrid> Page<S> findAllByDescriptionLikeIgnoreCase(String description, Pageable pageable);

    // Search by genera
    <S extends Hybrid> Page<S> findAllByGeneraCodeEqualsIgnoreCase(String generaCode, Pageable pageable);

    <S extends Hybrid> Page<S> findAllByGeneraCodeEqualsIgnoreCaseAndCodeLike(String generaCode, String code,
            Pageable pageable);

    <S extends Hybrid> Page<S> findAllByGeneraCodeEqualsIgnoreCaseAndCodeIn(String generaCode, Collection<String> codes,
            Pageable pageable);

    // Search by mother and/or father
    <S extends Hybrid> Page<S> findAllByMotherCodeEqualsIgnoreCase(String motherCode, Pageable pageable);

    <S extends Hybrid> Page<S> findAllByFatherCodeEqualsIgnoreCase(String fatherCode, Pageable pageable);

    <S extends Hybrid> Page<S> findAllByMotherCodeEqualsIgnoreCaseAndFatherCodeEqualsIgnoreCase(String motherCode,
            String fatherCode, Pageable pageable);

    <S extends Hybrid> Page<S> findAllByMotherCodeEqualsIgnoreCaseOrFatherCodeEqualsIgnoreCase(String motherCode,
            String fatherCode, Pageable pageable);
}
