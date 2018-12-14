package ru.shcheglov.dto;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.model.Category;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexey Shcheglov
 * @version dated 14.12.2018
 */

@XmlRootElement
public final class CategoryDTO extends AbstractDTO {

    @Nullable
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(@NotNull final Category category) {
        super.setId(category.getId());
        name = category.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
