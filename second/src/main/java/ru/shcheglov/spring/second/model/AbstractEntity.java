package ru.shcheglov.spring.second.model;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@Getter
public abstract class AbstractEntity {

    @NotNull
    private String id = UUID.randomUUID().toString();

}
