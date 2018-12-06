package ru.shcheglov.geekbrains.hw.hw3.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 06.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "category")
public class Category extends AbstractEntity {

    private static final long serialVersionUID = -3322719334031553726L;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Ad> ads;

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name +
                '}';
    }
}
