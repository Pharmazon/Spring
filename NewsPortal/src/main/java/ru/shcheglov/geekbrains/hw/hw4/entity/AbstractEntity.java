package ru.shcheglov.geekbrains.hw.hw4.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * @author Alexey Shcheglov
 * @version dated 07.12.2018
 */

@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();
}
