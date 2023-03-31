package za.co.neoflora.dao.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import za.co.neoflora.dao.domain.Photo;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class HybridDTO {
    @NonNull
    private Long id;
    @NonNull
    private String code;
    private String description;
    private String comments;

    private GeneraDTO genera;
    private HybridDTO mother;
    private HybridDTO father;
    private SeedTypeDTO seed;
    private OffspringTypeDTO offspring;

    private Set<Photo> photos;

    @Override
    public String toString() {
        return genera.getCode() + " " + code + " = " + mother.getCode() + " x " + father.getCode() +
                " - " + description;
    }
}
