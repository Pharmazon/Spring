package ru.shcheglov.model.eav;

import lombok.*;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.common.AbstractEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_ads_attributes_values")
@EqualsAndHashCode(callSuper = true)
@NamedQueries({
        @NamedQuery(name = "AdAttributeValue.findAll", query = "SELECT a FROM AdAttributeValue a"),
        @NamedQuery(name = "AdAttributeValue.deleteAll", query = "DELETE FROM AdAttributeValue a")
})
public class AdAttributeValue extends AbstractEntity {

    @Column(name = "string_value")
    private String stringValue;

    @Column(name = "boolean_value")
    private Boolean booleanValue;

    @Column(name = "date_value")
    private LocalDateTime dateValue;

    @Column(name = "numeric_value")
    private BigDecimal numericValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ad_id")
    private Ad ad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;

}
