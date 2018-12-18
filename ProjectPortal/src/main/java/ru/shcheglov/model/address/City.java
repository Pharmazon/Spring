package ru.shcheglov.model.address;

import ru.shcheglov.model.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 18.12.2018
 */

@Entity
@Table(name = "city")
@NamedQueries({
        @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
        @NamedQuery(name = "City.deleteAll", query = "DELETE FROM City c")
})
public class City extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "city_type_id")
    private CityType cityType;

    @OneToMany(mappedBy = "city")
    private List<Address> addresses;

    public CityType getCityType() {
        return cityType;
    }

    public void setCityType(CityType cityType) {
        this.cityType = cityType;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "City=" + cityType.getShortName() + " " + super.getName();
    }

}
