package ru.shcheglov.model.eav;

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
@Table(name = "app_attribute_types")
@EqualsAndHashCode(callSuper = true)
@NamedQueries({
        @NamedQuery(name = "AttributeType.findAll", query = "SELECT a FROM AttributeType a"),
        @NamedQuery(name = "AttributeType.deleteAll", query = "DELETE FROM AttributeType a")
})
public class AttributeType extends AbstractEntity {

    @OneToMany(mappedBy = "attributeType", fetch = FetchType.LAZY)
    private List<Attribute> attributes;

}
