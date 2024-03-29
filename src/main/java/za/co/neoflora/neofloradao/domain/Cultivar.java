package za.co.neoflora.neofloradao.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Data
@Entity(name = "cultivar")
public class Cultivar {
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

    @OneToOne
    @JoinColumn(name = "hybrid_id")
    private Hybrid hybrid;

    @ManyToMany
    @JoinTable(name = "cultivar_photo",
            joinColumns = @JoinColumn(name = "cultivar_id"),
            inverseJoinColumns = @JoinColumn(name = "photo_id"))
    @ToString.Exclude
    private Set<Photo> photos;

    @Version
    private Integer version;
}
