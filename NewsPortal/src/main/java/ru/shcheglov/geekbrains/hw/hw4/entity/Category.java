package ru.shcheglov.geekbrains.hw.hw4.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 06.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "ads")
@Entity
@Table(name = "category")
@NamedQuery(name = "Category.findAll", query = "SELECT a FROM Category a")
@NamedQuery(name = "Category.deleteAll", query = "DELETE FROM Category a")
public class Category extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Ad> ads;
}
