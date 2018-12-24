package ru.shcheglov.model;

import lombok.*;
import ru.shcheglov.model.common.AbstractEntity;
import ru.shcheglov.model.eav.AdAttributeValue;
import ru.shcheglov.model.user.UserProfile;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 06.12.2018
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_ads")
@EqualsAndHashCode(callSuper = true)
@NamedQueries({
        @NamedQuery(name = "Ad.findAll", query = "SELECT a FROM Ad a"),
        @NamedQuery(name = "Ad.deleteAll", query = "DELETE FROM Ad a")
})
public class Ad extends AbstractEntity {

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private LocalDateTime dateTime;

    @Column(name = "price")
    private BigInteger price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserProfile user;

    @OneToMany(mappedBy = "attribute", fetch = FetchType.LAZY)
    private List<AdAttributeValue> eavs;

}
