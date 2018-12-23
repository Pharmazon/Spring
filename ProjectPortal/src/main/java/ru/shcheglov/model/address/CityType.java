package ru.shcheglov.model.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.shcheglov.model.common.AbstractEntity;

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
@Table(name = "app_city_types")
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
