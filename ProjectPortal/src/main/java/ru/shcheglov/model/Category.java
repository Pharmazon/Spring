package ru.shcheglov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.shcheglov.model.basic.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */


@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "SELECT a FROM Category a"),
        @NamedQuery(name = "Category.deleteAll", query = "DELETE FROM Category a")
})
public class Category extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parentId;

    @OneToMany(mappedBy = "parentId")
    private List<Category> subCategories;

    @OneToMany(mappedBy = "category")
    private List<Ad> ads;

}
