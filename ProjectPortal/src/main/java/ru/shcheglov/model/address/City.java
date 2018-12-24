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
@Table(name = "app_cities")
@EqualsAndHashCode(callSuper = true)
@NamedQueries({
        @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
        @NamedQuery(name = "City.deleteAll", query = "DELETE FROM City c")
})
public class City extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_type_id")
    private CityType cityType;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<Address> addresses;

    @Override
    public String toString() {
        return "City=" + cityType.getShortName() + " " + getName();
    }

}
