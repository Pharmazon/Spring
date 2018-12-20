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
@Table(name = "regions")
@NamedQueries({
        @NamedQuery(name = "Region.findAll", query = "SELECT c FROM Region c"),
        @NamedQuery(name = "Region.deleteAll", query = "DELETE FROM Region c")
})
public class Region extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "region_type_id")
    private RegionType regionType;

    @OneToMany(mappedBy = "region")
    private List<Address> addresses;

    @Override
    public String toString() {
        return "Region=" + getName() + " " + regionType.getShortName();
    }
}
