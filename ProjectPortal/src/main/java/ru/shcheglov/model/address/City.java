package ru.shcheglov.model.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.shcheglov.model.AbstractEntity;

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

    @Override
    public String toString() {
        return "City=" + cityType.getShortName() + " " + getName();
    }

}
