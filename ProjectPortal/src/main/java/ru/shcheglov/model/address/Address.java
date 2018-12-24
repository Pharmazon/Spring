package ru.shcheglov.model.address;

import lombok.*;
import ru.shcheglov.model.common.AbstractEntity;
import ru.shcheglov.model.user.Company;

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
@Table(name = "app_addresses")
@EqualsAndHashCode(callSuper = true)
@NamedQueries({
        @NamedQuery(name = "Address.findAll", query = "SELECT c FROM Address c"),
        @NamedQuery(name = "Address.deleteAll", query = "DELETE FROM Address c")
})
public class Address extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id")
    private Street street;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<Company> companies;

    @Override
    public String toString() {
        return region + ", " + city + ", " + street;
    }

}
