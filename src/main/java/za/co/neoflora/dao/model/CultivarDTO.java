package za.co.neoflora.dao.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import za.co.neoflora.dao.domain.PhotoEntity;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class CultivarDTO {
    @NotNull
    private Long id;
    @NotBlank
    private String codes;
    private String descriptions;
    private String comments;

    private CultivarDTO mother;
    private CultivarDTO father;

    private Set<SeedTypeDTO> seeds;
    private Set<OffspringTypeDTO> offspring;
    private Set<PhotoEntity> photos;
}
