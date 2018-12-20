package ru.shcheglov.model.eav;

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
@Table(name = "attribute_types")
@NamedQueries({
        @NamedQuery(name = "AttributeType.findAll", query = "SELECT a FROM AttributeType a"),
        @NamedQuery(name = "AttributeType.deleteAll", query = "DELETE FROM AttributeType a")
})
public final class AttributeType extends AbstractEntity {

    @OneToMany(mappedBy = "attributeType")
    private List<Attribute> attributes;
    
}
