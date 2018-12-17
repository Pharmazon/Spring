package ru.shcheglov.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

@Entity
@Table(name = "category")
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "SELECT a FROM Category a"),
        @NamedQuery(name = "Category.deleteAll", query = "DELETE FROM Category a")
})
public class Category extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Ad> ads;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(final List<Ad> ads) {
        this.ads = ads;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
