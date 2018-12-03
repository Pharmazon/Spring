package ru.shcheglov.geekbrains.lessons.lesson3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 02.12.2018
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "category")
class Category extends AbstractEntity {

    private static final long serialVersionUID = -5071496579337428065L;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}
