package za.co.neoflora.dao.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "genera_id")
    private Genera genera;
    @ManyToOne
    @JoinColumn(name = "mother_id")
    private Cultivar mother;
    @ManyToOne
    @JoinColumn(name = "father_id")
    private Cultivar father;
    @ManyToOne
    @JoinColumn(name = "seed_type_id")
    private SeedType seed;
    @ManyToOne
    @JoinColumn(name = "offspring_type_id")
    private OffspringType offspring;

    @ManyToMany
    @JoinTable(name = "cultivar_photo",
            joinColumns = @JoinColumn(name = "cultivar_id"),
            inverseJoinColumns = @JoinColumn(name = "photo_id"))
    @ToString.Exclude
    private Set<Photo> photos;

    @Version
    private Integer version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cultivar that = (Cultivar) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
