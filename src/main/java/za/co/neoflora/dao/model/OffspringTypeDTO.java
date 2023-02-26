package za.co.neoflora.dao.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OffspringTypeDTO {
    @NotNull
    private Long id;
    @NotBlank
    private String offspringType;
   private String offspringCode;
    private Boolean isDefault;
}
