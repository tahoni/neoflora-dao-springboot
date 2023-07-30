package za.co.neoflora.neofloradao.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class HybridDTO {
    @NonNull
    private Long id;
    @NotBlank
    private String code;
    private String description;
    private String comments;

    private GeneraDTO genera;
    private HybridDTO mother;
    private HybridDTO father;
    private SeedTypeDTO seed;
    private OffspringTypeDTO offspring;

    private Set<PhotoDTO> photos;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof HybridDTO hybridDTO))
            return false;
        return getCode().equals(hybridDTO.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }

    @Override
    public String toString() {
        return genera.getCode() + " " + code + " = " + mother.getCode() + " x " + father.getCode() +
                " - " + description;
    }
}
