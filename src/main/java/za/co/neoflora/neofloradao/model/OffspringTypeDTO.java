package za.co.neoflora.neofloradao.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Objects;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class OffspringTypeDTO {
    @NonNull
    private Long id;
    @NotBlank
    private String code;
    @NotBlank
    private String type;
    private Boolean isDefault;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof OffspringTypeDTO that))
            return false;
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
