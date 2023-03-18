package za.co.neoflora.dao.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class PhotoDTO {
    @NonNull
    private Long id;
    @NonNull
    private String photo;
    private String description;
    private String comments;

    private Set<CultivarDTO> cultivars;

    @Override
    public String toString() {
        return description;
    }
}
