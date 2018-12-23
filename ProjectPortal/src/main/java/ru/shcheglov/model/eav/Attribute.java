package ru.shcheglov.model.eav;

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
@Table(name = "app_attributes")
@NamedQueries({
        @NamedQuery(name = "Attribute.findAll", query = "SELECT a FROM Attribute a"),
        @NamedQuery(name = "Attribute.deleteAll", query = "DELETE FROM Attribute a")
})
public class Attribute extends AbstractEntity {

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_type_id")
    private AttributeType attributeType;

    @OneToMany(mappedBy = "ad", fetch = FetchType.LAZY)
    private List<AdAttributeValue> eavs;

}
