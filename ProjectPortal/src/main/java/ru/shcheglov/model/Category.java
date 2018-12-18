package ru.shcheglov.model;

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
public class  Category extends AbstractEntity {

    @OneToMany(mappedBy = "category")
    private List<Ad> ads;

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(final List<Ad> ads) {
        this.ads = ads;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + super.getName() + '\'' +
                ", ads=" + ads +
                '}';
    }
}
