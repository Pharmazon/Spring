package ru.shcheglov.geekbrains.hw.hw3.entity;

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
public class Ad extends AbstractEntity {

    private static final long serialVersionUID = 4295794125768965807L;

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

    @Override
    public String toString() {
        return "Ad{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", number='" + number + '\'' +
                ", category=" + category +
                ", company=" + company +
                '}';
    }
}
