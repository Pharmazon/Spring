package ru.shcheglov.model;

import javax.persistence.*;

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
        @NamedQuery(name = "Ad.findAllByCategory", query = "SELECT a FROM Ad a WHERE a.category = :category")
})
public class Ad extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "number")
    private String number;

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

    @Override
    public String toString() {
        return "Ad{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", number='" + number + '\'' +
                ", category=" + category + '\'' +
                ", company=" + company +
                '}';
    }
}
