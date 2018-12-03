package ru.shcheglov.geekbrains.lessons.lesson3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alexey Shcheglov
 * @version dated 02.12.2018
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 5218556784302717906L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
