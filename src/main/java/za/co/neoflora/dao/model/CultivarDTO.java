package za.co.neoflora.dao.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Objects;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class CultivarDTO {
    @NonNull
    private Long id;
    @NotBlank
    private String code;
    private String description;
    private String comments;

    private HybridDTO hybrid;

    private Set<PhotoDTO> photos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CultivarDTO that)) return false;
        return getCode().equals(that.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }

    @Override
    public String toString() {
        return code + " = " + hybrid.getCode() + " - " + description;
    }
}
