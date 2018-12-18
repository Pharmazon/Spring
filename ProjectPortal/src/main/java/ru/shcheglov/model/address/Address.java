package ru.shcheglov.model.address;

import ru.shcheglov.model.AbstractEntity;
import ru.shcheglov.model.Company;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 18.12.2018
 */

@Entity
@Table(name = "address")
@NamedQueries({
        @NamedQuery(name = "Address.findAll", query = "SELECT c FROM Address c"),
        @NamedQuery(name = "Address.deleteAll", query = "DELETE FROM Address c")
})
public class Address extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;

    @OneToMany(mappedBy = "address")
    private List<Company> companies;

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return region + ", " + city + ", " + street;
    }
}
