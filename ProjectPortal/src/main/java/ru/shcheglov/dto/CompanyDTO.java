package ru.shcheglov.dto;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.model.Company;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexey Shcheglov
 * @version dated 14.12.2018
 */

@XmlRootElement
public final class CompanyDTO {

    @NotNull
    private String id;

    @Nullable
    private String name;

    @Nullable
    private String description;

    @Nullable
    private String address;

    public CompanyDTO() {
    }

    public CompanyDTO(@NotNull final Company company) {
        id = company.getId();
        name = company.getName();
        description = company.getDescription();
        address = company.getAddress();
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

}
