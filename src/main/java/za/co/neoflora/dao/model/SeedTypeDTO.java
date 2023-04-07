package za.co.neoflora.dao.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Objects;

@Data
@RequiredArgsConstructor
public class SeedTypeDTO {
    @NonNull
    private Long id;
    @NotBlank
    private String code;
    @NotBlank
    private String type;
    private Boolean isDefault;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeedTypeDTO that)) return false;
        return Objects.equals(getCode(), that.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }

    @Override
    public String toString() {
        return code + " - " + type;
    }
}
