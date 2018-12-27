package ru.shcheglov.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.dto.common.AbstractDTO;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;
import ru.shcheglov.model.user.UserProfile;

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
public class AdDTO extends AbstractDTO<Ad> {

    @Nullable
    private String content;

    @NotNull
    private String dateTime;

    @NotNull
    private String price;

    @NotNull
    private String categoryId;

    @NotNull
    private String userId;

    public AdDTO(@NotNull final Ad ad) {
        content = ad.getContent();
        dateTime = ad.getDateTime().toString();
        price = ad.getPrice().toString();
        final Category category = ad.getCategory();
        categoryId = category.getId();
        final UserProfile user = ad.getUser();
        userId = user.getId();
    }

}
