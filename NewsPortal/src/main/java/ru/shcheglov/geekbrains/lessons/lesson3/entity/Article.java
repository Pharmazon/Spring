package ru.shcheglov.geekbrains.lessons.lesson3.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Alexey Shcheglov
 * @version dated 02.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "article")
public class Article extends AbstractEntity {

    private static final long serialVersionUID = 5610810999814106039L;

    @Column(name = "published_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedDate;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
