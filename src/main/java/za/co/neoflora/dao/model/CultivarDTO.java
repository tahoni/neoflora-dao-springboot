package za.co.neoflora.dao.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import za.co.neoflora.dao.domain.Photo;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class CultivarDTO {
    @NonNull
    private Long id;
    @NonNull
    private String code;
    private String descriptions;
    private String comments;

    private GeneraDTO genera;
    private CultivarDTO mother;
    private CultivarDTO father;
    private SeedTypeDTO seed;
    private OffspringTypeDTO offspring;

    private Set<Photo> photos;
}
