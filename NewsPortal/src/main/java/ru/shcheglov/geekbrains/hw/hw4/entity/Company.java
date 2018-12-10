package ru.shcheglov.geekbrains.hw.hw4.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 07.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "company")
@NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
@NamedQuery(name = "Company.deleteAll", query = "DELETE FROM Company c")
public class Company extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "company")
    private List<Ad> ads;
}
