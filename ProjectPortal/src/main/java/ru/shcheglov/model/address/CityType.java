package ru.shcheglov.model.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.shcheglov.model.basic.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "city_types")
public class CityType extends AbstractEntity {

    @Column(name = "short")
    private String shortName;

    @OneToMany(mappedBy = "cityType")
    private List<City> cities;

    @Override
    public String toString() {
        return "CityType=" + shortName;
    }

}
