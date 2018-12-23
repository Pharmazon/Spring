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
 * @version dated 19.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_street_names")
@NamedQueries({
        @NamedQuery(name = "StreetName.findAll", query = "SELECT c FROM StreetName c"),
        @NamedQuery(name = "StreetName.deleteAll", query = "DELETE FROM StreetName c")
})
public class StreetName extends AbstractEntity {

    @OneToMany(mappedBy = "streetName", fetch = FetchType.LAZY)
    private List<Street> streets;

}
