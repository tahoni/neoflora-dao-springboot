package za.co.neoflora.neofloradao.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Entity(name = "offspring_type")
public class OffspringType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "offspring_type", nullable = false, unique = true, length = 48)
    private String type;
    @Column(name = "offspring_code", unique = true, length = 24)
    private String code;
    private Boolean isDefault;

    @Version
    private Integer version;
}
