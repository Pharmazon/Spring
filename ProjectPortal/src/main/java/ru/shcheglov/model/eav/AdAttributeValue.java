package ru.shcheglov.model.eav;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.shcheglov.model.basic.AbstractEntity;
import ru.shcheglov.model.Ad;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ads_attributes_values")
@NamedQueries({
        @NamedQuery(name = "AdAttributeValue.findAll", query = "SELECT a FROM AdAttributeValue a"),
        @NamedQuery(name = "AdAttributeValue.deleteAll", query = "DELETE FROM AdAttributeValue a")
})
public final class AdAttributeValue extends AbstractEntity {

    @Column(name = "string_value")
    private String stringValue;

    @Column(name = "boolean_value")
    private Boolean booleanValue;

    @Column(name = "date_value")
    private LocalDateTime dateValue;

    @Column(name = "numeric_value")
    private BigDecimal numericValue;

    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Ad ad;

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;
    
}
