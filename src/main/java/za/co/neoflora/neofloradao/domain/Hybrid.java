package za.co.neoflora.neofloradao.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Data
@Entity(name = "hybrid")
public class Hybrid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "codes", nullable = false, unique = true, length = 48)
    private String code;
    @Column(name = "descr", length = 126)
    private String description;
    @Column(name = "comments", length = 512)
    private String comments;

    @ManyToOne
    @JoinColumn(name = "genera_id")
    private Genera genera;
    @ManyToOne
    @JoinColumn(name = "mother_id")
    private Hybrid mother;
    @ManyToOne
    @JoinColumn(name = "father_id")
    private Hybrid father;
    @ManyToOne
    @JoinColumn(name = "seed_type_id")
    private SeedType seed;
    @ManyToOne
    @JoinColumn(name = "offspring_type_id")
    private OffspringType offspring;

    @ManyToMany
    @JoinTable(name = "hybrid_photo",
            joinColumns = @JoinColumn(name = "hybrid_id"),
            inverseJoinColumns = @JoinColumn(name = "photo_id"))
    @ToString.Exclude
    private Set<Photo> photos;

    @Version
    private Integer version;
}
