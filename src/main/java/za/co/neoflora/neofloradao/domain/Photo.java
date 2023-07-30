package za.co.neoflora.neofloradao.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Data
@Entity(name = "photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "image", nullable = false)
    private String image;
    @Column(name = "descr", length = 126)
    private String description;
    @Column(name = "comments", length = 512)
    private String comments;

    @ManyToMany
    @JoinTable(name = "hybrid_photo", joinColumns = @JoinColumn(name = "photo_id"), inverseJoinColumns = @JoinColumn(name = "hybrid_id"))
    @ToString.Exclude
    private Set<Hybrid> hybrids;

    @ManyToMany
    @JoinTable(name = "cultivar_photo", joinColumns = @JoinColumn(name = "photo_id"), inverseJoinColumns = @JoinColumn(name = "cultivar_id"))
    @ToString.Exclude
    private Set<Cultivar> cultivars;

    @Version
    private Integer version;
}
