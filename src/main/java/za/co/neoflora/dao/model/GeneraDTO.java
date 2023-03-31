package za.co.neoflora.dao.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class GeneraDTO {
    @NonNull
    private Long id;
    @NonNull
    private String code;
    private String description;
    private String comments;

    private Set<HybridDTO> hybrids;

    @Override
    public String toString() {
        return code + " - " + description;
    }
}
