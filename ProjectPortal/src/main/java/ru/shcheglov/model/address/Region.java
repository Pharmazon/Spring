package ru.shcheglov.model.address;

import ru.shcheglov.model.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 18.12.2018
 */

@Entity
@Table(name = "region")
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

    public RegionType getRegionType() {
        return regionType;
    }

    public void setRegionType(RegionType regionType) {
        this.regionType = regionType;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Region=" + super.getName() + " " + regionType.getShortName();
    }
}
