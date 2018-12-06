package ru.shcheglov.geekbrains.hw.hw3.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Alexey Shcheglov
 * @version dated 02.12.2018
 */

@Data
@MappedSuperclass
abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 7458960417350110790L;

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();
}
