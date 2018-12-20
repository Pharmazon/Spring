package ru.shcheglov.model.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.shcheglov.model.basic.AbstractEntity;

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
@Table(name = "street_names")
@NamedQueries({
        @NamedQuery(name = "StreetName.findAll", query = "SELECT c FROM StreetName c"),
        @NamedQuery(name = "StreetName.deleteAll", query = "DELETE FROM StreetName c")
})
public final class StreetName extends AbstractEntity {

    @OneToMany(mappedBy = "streetName")
    private List<Street> streets;

}
