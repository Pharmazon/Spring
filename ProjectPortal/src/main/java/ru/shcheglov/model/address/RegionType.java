package ru.shcheglov.model.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.shcheglov.model.basic.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 18.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "region_types")
@NamedQueries({
        @NamedQuery(name = "RegionType.findAll", query = "SELECT c FROM RegionType c"),
        @NamedQuery(name = "RegionType.deleteAll", query = "DELETE FROM RegionType c")
})
public final class RegionType extends AbstractEntity {

    @Column(name = "short")
    private String shortName;

    @OneToMany(mappedBy = "regionType")
    private List<Region> regions;

    @Override
    public String toString() {
        return "RegionTypeRepository=" + shortName;
    }
}
