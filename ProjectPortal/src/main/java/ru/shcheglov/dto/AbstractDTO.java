package ru.shcheglov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexey Shcheglov
 * @version dated 14.12.2018
 */

@Data
@NoArgsConstructor
@XmlRootElement
public abstract class AbstractDTO {

    @NotNull
    private String id;

    @Nullable
    private String name;

}
