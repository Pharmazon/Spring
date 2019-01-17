package ru.shcheglov.spring.second.model;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@Getter
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @NotNull
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

}
