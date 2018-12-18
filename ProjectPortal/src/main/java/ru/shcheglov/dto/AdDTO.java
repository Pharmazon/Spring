package ru.shcheglov.dto;

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

    public AdDTO() {
    }

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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
