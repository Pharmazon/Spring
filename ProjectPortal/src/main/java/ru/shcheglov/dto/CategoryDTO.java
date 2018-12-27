package ru.shcheglov.dto;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.dto.common.AbstractDTO;
import ru.shcheglov.model.Category;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexey Shcheglov
 * @version dated 27.12.2018
 */

@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CategoryDTO extends AbstractDTO<Category> {

    @Nullable
    private String parentId;

    public CategoryDTO(@NotNull final Category category) {
        @Nullable final Category parent = category.getParent();
        parentId = parent != null ? parent.getId() : null;
    }

}
