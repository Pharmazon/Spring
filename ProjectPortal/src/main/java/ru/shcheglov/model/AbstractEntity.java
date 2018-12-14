package ru.shcheglov.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

}
