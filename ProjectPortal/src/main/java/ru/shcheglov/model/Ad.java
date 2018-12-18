package ru.shcheglov.model;

import ru.shcheglov.model.eav.AttributeEAV;
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

@Entity
@Table(name = "ad")
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

    @ManyToMany
    @JoinTable(name = "ad_attributes")
    private List<AttributeEAV> attributes;

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getFormattedDateTime() {
        return dateTime.format(DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss"));
    }

    public String getFormattedDate() {
        return dateTime.format(DateTimeFormatter.ofPattern("dd.MM.uuuu"));
    }

    public String getFormattedTime() {
        return dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public List<AttributeEAV> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeEAV> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "name='" + super.getName() + '\'' +
                ", content='" + content + '\'' +
                ", dateTime=" + dateTime +
                ", price=" + price +
                ", category=" + category +
                ", user=" + user +
                '}';
    }
}
