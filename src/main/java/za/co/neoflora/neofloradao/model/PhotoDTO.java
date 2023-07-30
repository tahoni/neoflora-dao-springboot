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
public class PhotoDTO {
    @NonNull
    private Long id;
    @NotBlank
    private String photo;
    private String description;
    private String comments;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PhotoDTO photoDTO))
            return false;
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
