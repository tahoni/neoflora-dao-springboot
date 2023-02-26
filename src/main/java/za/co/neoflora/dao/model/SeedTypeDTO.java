package za.co.neoflora.dao.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SeedTypeDTO {
    @NotNull
    private Long id;
    @NotBlank
    private String seedType;
    private String seedCode;
    private Boolean isDefault;
}
