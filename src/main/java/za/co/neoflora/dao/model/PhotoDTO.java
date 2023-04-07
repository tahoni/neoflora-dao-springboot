package za.co.neoflora.dao.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Objects;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class PhotoDTO {
    @NonNull
    private Long id;
    @NotBlank
    private String photo;
    private String description;
    private String comments;

    private Set<HybridDTO> hybrids;
    private Set<CultivarDTO> cultivars;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhotoDTO photoDTO)) return false;
        return Objects.equals(getPhoto(), photoDTO.getPhoto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPhoto());
    }

    @Override
    public String toString() {
        return description;
    }
}
