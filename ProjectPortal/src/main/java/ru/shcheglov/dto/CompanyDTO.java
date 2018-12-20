package ru.shcheglov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.model.address.Address;
import ru.shcheglov.model.user.Company;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexey Shcheglov
 * @version dated 14.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public final class CompanyDTO extends AbstractDTO {

    @Nullable
    private String name;

    @Nullable
    private String description;

    @Nullable
    private Address address;

    public CompanyDTO(@NotNull final Company company) {
        super.setId(company.getId());
        name = company.getName();
        description = company.getDescription();
        address = company.getAddress();
    }

}
