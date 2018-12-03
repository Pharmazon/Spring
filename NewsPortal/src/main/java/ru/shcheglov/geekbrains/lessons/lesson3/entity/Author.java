package ru.shcheglov.geekbrains.lessons.lesson3.entity;

import lombok.*;

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
@Table(name = "author")
class Author extends AbstractEntity {

    private static final long serialVersionUID = 117525387672899743L;
    
    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "author")
    private List<Article> articles;
}
