package za.co.neoflora.dao.domain;

import jakarta.persistence.*;
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
@Entity(name = "genera")
public class Genera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "codes", nullable = false, unique = true, length = 48)
    private String code;
    @Column(name = "descr", length = 126)
    private String description;
    @Column(name = "comments", length = 512)
    private String comments;

    @OneToMany(mappedBy = "genera")
    @ToString.Exclude
    private Set<Cultivar> cultivars;

    @Version
    private Integer version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Genera that = (Genera) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return code + " - " + description;
    }
}
