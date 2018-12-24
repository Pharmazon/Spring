package ru.shcheglov.dto.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.model.common.AbstractEntity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexey Shcheglov
 * @version dated 14.12.2018
 */

@Data
@NoArgsConstructor
@XmlRootElement
public abstract class AbstractDTO<T extends AbstractEntity> {

    @NotNull
    private String id;

    @Nullable
    private String name;

    public AbstractDTO(T entity) {
        setId(entity.getId());
        setName(entity.getName());
        name = entity.getName();
    }

}
