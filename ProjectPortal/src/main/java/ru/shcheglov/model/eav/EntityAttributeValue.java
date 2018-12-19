package ru.shcheglov.model.eav;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.shcheglov.model.AbstractEntity;
import ru.shcheglov.model.Ad;

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
@Table(name = "attribute")
public class EntityAttributeValue extends AbstractEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @ManyToMany(mappedBy = "attributes")
    private List<Ad> ads;

}
