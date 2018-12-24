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
@Table(name = "app_attributes")
@EqualsAndHashCode(callSuper = true)
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
