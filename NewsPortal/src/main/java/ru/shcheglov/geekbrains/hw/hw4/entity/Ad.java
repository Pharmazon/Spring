package ru.shcheglov.geekbrains.hw.hw4.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author Alexey Shcheglov
 * @version dated 06.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ad")
@NamedQuery(name = "Ad.findAll", query = "SELECT a FROM Ad a")
@NamedQuery(name = "Ad.deleteAll", query = "DELETE FROM Ad a")
@NamedQuery(name = "Ad.findAllByCompany", query = "SELECT a FROM Ad a WHERE a.company = :company")
@NamedQuery(name = "Ad.findAllByCategory", query = "SELECT a FROM Ad a WHERE a.category = :category")
public class Ad extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
