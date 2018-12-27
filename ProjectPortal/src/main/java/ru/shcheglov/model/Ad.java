package ru.shcheglov.model;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import ru.shcheglov.model.common.AbstractEntity;
import ru.shcheglov.model.eav.AdAttributeValue;
import ru.shcheglov.model.user.UserProfile;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        @NamedQuery(name = "Ad.findAll",
                query = "SELECT a FROM Ad a LEFT JOIN FETCH a.category"),
        @NamedQuery(name = "Ad.deleteAll", query = "DELETE FROM Ad a"),
        @NamedQuery(name = "Ad.findOne",
                query = "SELECT a FROM Ad a LEFT JOIN FETCH a.category cat LEFT JOIN FETCH cat.parent WHERE a.id = :adId")
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

    public String getFormattedDateTime() {
        return dateTime.format(DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss"));
    }

    public String getFormattedDate() {
        return dateTime.format(DateTimeFormatter.ofPattern("dd.MM.uuuu"));
    }

    public String getFormattedTime() {
        return dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

}
