package za.co.neoflora.dao.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@RequiredArgsConstructor
public class OffspringTypeDTO {
    @NonNull
    private Long id;
    @NonNull
    private String type;
    private String code;
    private Boolean isDefault;
}
