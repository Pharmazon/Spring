package ru.shcheglov.model.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "name")
    private String name;

}
