package za.co.neoflora.dao.model;

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
public class GeneraDTO {
    @NonNull
    private Long id;
    @NotBlank
    private String code;
    private String description;
    private String comments;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof GeneraDTO generaDTO))
            return false;
        return getCode().equals(generaDTO.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }

    @Override
    public String toString() {
        return code + " - " + description;
    }
}
