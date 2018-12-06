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
@Table(name = "company")
public class Company extends AbstractEntity {

    private static final long serialVersionUID = 6340679465471703708L;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "company")
    private List<Ad> ads;
}
