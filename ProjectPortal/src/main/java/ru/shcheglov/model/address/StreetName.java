package ru.shcheglov.model.address;

import lombok.*;
import ru.shcheglov.model.common.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_street_names")
@EqualsAndHashCode(callSuper = true)
@NamedQueries({
        @NamedQuery(name = "StreetName.findAll", query = "SELECT c FROM StreetName c"),
        @NamedQuery(name = "StreetName.deleteAll", query = "DELETE FROM StreetName c")
})
public class StreetName extends AbstractEntity {

    @OneToMany(mappedBy = "streetName", fetch = FetchType.LAZY)
    private List<Street> streets;

}
