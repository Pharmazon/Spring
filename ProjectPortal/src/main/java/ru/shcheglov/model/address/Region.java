package ru.shcheglov.model.address;

import lombok.*;
import ru.shcheglov.model.common.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 18.12.2018
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_regions")
@EqualsAndHashCode(callSuper = true)
@NamedQueries({
        @NamedQuery(name = "Region.findAll", query = "SELECT c FROM Region c"),
        @NamedQuery(name = "Region.deleteAll", query = "DELETE FROM Region c")
})
public class Region extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_type_id")
    private RegionType regionType;

    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    private List<Address> addresses;

    @Override
    public String toString() {
        return "Region=" + getName() + " " + regionType.getShortName();
    }
}
