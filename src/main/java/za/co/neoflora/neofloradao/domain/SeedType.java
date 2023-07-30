package za.co.neoflora.neofloradao.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Entity(name = "seed_type")
public class SeedType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "seed_type", nullable = false, unique = true, length = 48)
    private String type;
    @Column(name = "seed_code", unique = true, length = 24)
    private String code;
    private Boolean isDefault;

    @Version
    private Integer version;
}
