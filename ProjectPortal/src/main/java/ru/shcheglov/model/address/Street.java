package ru.shcheglov.model.address;

import ru.shcheglov.model.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 18.12.2018
 */

@Entity
@Table(name = "street")
@NamedQueries({
        @NamedQuery(name = "Street.findAll", query = "SELECT c FROM Street c"),
        @NamedQuery(name = "Street.deleteAll", query = "DELETE FROM Street c")
})
public class Street extends AbstractEntity {

    @Column(name = "house")
    private Integer house;

    @ManyToOne
    @JoinColumn(name = "street_type_id")
    private StreetType streetType;

    @OneToMany(mappedBy = "street")
    private List<Address> addresses;

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public StreetType getStreetType() {
        return streetType;
    }

    public void setStreetType(StreetType streetType) {
        this.streetType = streetType;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Street=" + streetType.getShortName() + " " + super.getName() + ", д. " + house;
    }
}
