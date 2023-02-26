package za.co.neoflora.dao.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class PhotoDTO {
    @NotNull
    private Long id;
    @NotBlank
    private String photo;
    private String description;
    private String comments;

    private Set<CultivarDTO> cultivars;
}
