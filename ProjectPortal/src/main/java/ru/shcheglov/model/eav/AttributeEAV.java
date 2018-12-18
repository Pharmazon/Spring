package ru.shcheglov.model.eav;

import ru.shcheglov.model.AbstractEntity;
import ru.shcheglov.model.Ad;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Entity
@Table(name = "attribute")
public class AttributeEAV extends AbstractEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @ManyToMany(mappedBy = "attributes")
    private List<Ad> ads;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

}
