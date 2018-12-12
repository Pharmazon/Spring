package ru.shcheglov.geekbrains.hw.hw5.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 06.12.2018
 */

@Entity
@Table(name = "category")
@NamedQuery(name = "Category.findAll", query = "SELECT a FROM Category a")
@NamedQuery(name = "Category.deleteAll", query = "DELETE FROM Category a")
public class Category extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Ad> ads;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

}
