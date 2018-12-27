package ru.shcheglov.model;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import ru.shcheglov.model.common.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_categories")
@EqualsAndHashCode(callSuper = true)
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "SELECT a FROM Category a"),
        @NamedQuery(name = "Category.deleteAll", query = "DELETE FROM Category a")
})
public class Category extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Category> subCategories;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Ad> ads;
}
