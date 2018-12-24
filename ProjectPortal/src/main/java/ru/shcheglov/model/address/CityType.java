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
@Table(name = "app_city_types")
@EqualsAndHashCode(callSuper = true)
@NamedQueries({
        @NamedQuery(name = "CityType.findAll", query = "SELECT c FROM CityType c"),
        @NamedQuery(name = "CityType.deleteAll", query = "DELETE FROM CityType c")
})
public class CityType extends AbstractEntity {

    @Column(name = "short")
    private String shortName;

    @OneToMany(mappedBy = "cityType", fetch = FetchType.LAZY)
    private List<City> cities;

    @Override
    public String toString() {
        return "CityTypeRepository=" + shortName;
    }

}
