package za.co.neoflora.dao.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class GeneraDTO {
    @NotNull
    private Long id;
    @NotBlank
    private String description;

    private Set<CultivarDTO> cultivars;
}
