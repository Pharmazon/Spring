package ru.shcheglov.geekbrains.hw.hw3.entity;

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
public class Category extends AbstractEntity {

    private static final long serialVersionUID = -3322719334031553726L;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Ad> ads;
}
