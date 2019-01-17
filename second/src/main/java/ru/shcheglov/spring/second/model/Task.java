package ru.shcheglov.spring.second.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task extends AbstractEntity {

    @Nullable
    private String name = "";

    @Nullable
    private String description = "";

    @Nullable
    private Person person = null;

    public Task(@Nullable final String name) {
        this.name = name;
    }

}
