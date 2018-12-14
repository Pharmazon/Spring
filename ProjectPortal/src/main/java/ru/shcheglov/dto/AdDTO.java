package ru.shcheglov.dto;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;
import ru.shcheglov.model.Company;

import javax.xml.bind.annotation.XmlRootElement;

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

    @NotNull
    private String categoryId;

    @NotNull
    private String companyId;

    public AdDTO() {
    }

    public AdDTO(@NotNull final Ad ad) {
        super.setId(ad.getId());
        name = ad.getName();
        content = ad.getContent();
        number = ad.getNumber();
        @NotNull final Company company = ad.getCompany();
        companyId = company.getId();
        @NotNull final Category category = ad.getCategory();
        categoryId = category.getId();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

}
