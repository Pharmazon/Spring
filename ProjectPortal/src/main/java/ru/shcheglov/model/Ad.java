package ru.shcheglov.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Alexey Shcheglov
 * @version dated 06.12.2018
 */

@Entity
@Table(name = "ad")
@NamedQueries({
        @NamedQuery(name = "Ad.findAll", query = "SELECT a FROM Ad a"),
        @NamedQuery(name = "Ad.deleteAll", query = "DELETE FROM Ad a"),
        @NamedQuery(name = "Ad.findAllByCompany", query = "SELECT a FROM Ad a WHERE a.company = :company"),
        @NamedQuery(name = "Ad.findAllByCategory", query = "SELECT a FROM Ad a WHERE a.category = :category"),
        @NamedQuery(name = "Company.findAllAds", query = "SELECT a FROM Ad a INNER JOIN a.company c WHERE c = :company"),
        @NamedQuery(name = "Category.findAllAds", query = "SELECT a FROM Ad a INNER JOIN a.category c WHERE c = :category")
})
public class Ad extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "number")
    private String number;

    @Column(name = "date")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(final Company company) {
        this.company = company;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getFormattedDateTime() {
        return dateTime.format(DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss"));
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", number='" + number + '\'' +
                ", dateTime=" + dateTime +
                ", category=" + category +
                ", company=" + company +
                '}';
    }
}
