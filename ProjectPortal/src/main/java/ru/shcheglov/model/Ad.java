package ru.shcheglov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.shcheglov.model.basic.AbstractEntity;
import ru.shcheglov.model.eav.AdAttributeValue;
import ru.shcheglov.model.user.User;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 06.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ads")
@NamedQueries({
        @NamedQuery(name = "Ad.findAll", query = "SELECT a FROM Ad a"),
        @NamedQuery(name = "Ad.deleteAll", query = "DELETE FROM Ad a"),
//        @NamedQuery(name = "Ad.findAllAdsByCompany", query = "SELECT a FROM Ad a WHERE a.company = :company"),
        @NamedQuery(name = "Ad.findAllAdsByCategory", query = "SELECT a FROM Ad a WHERE a.category = :category"),
//        @NamedQuery(name = "Company.findAllAds", query = "SELECT a FROM Ad a INNER JOIN a.company c WHERE c = :company"),
        @NamedQuery(name = "Category.findAllAds", query = "SELECT a FROM Ad a INNER JOIN a.category c WHERE c = :category")
})
public class Ad extends AbstractEntity {

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private LocalDateTime dateTime;

    @Column(name = "price")
    private BigInteger price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "attribute")
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
