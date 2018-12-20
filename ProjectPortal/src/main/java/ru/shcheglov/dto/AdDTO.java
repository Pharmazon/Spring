package ru.shcheglov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;
import ru.shcheglov.model.user.User;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * @author Alexey Shcheglov
 * @version dated 14.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public final class AdDTO extends AbstractDTO {

    @Nullable
    private String name;

    @Nullable
    private String content;

    @Nullable
    private String number;

    @Nullable
    private LocalDateTime dateTime;

    @Nullable
    private BigInteger price;

    @Nullable
    private String categoryId;

    @Nullable
    private String userId;

    public AdDTO(@NotNull final Ad ad) {
        super.setId(ad.getId());
        super.setName(ad.getName());
        name = ad.getName();
        content = ad.getContent();
        dateTime = ad.getDateTime();
        price = ad.getPrice();
        @NotNull final User user = ad.getUser();
        userId = user.getId();
        @NotNull final Category category = ad.getCategory();
        categoryId = category.getId();
    }

}
