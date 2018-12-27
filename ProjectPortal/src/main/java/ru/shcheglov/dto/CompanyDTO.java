package ru.shcheglov.dto;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.dto.common.AbstractDTO;
import ru.shcheglov.model.address.Address;
import ru.shcheglov.model.user.Company;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexey Shcheglov
 * @version dated 14.12.2018
 */

@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public final class CompanyDTO extends AbstractDTO<Company> {

    @Nullable
    private String description;

    @Nullable
    private String addressId;

    public CompanyDTO(@NotNull final Company company) {
        description = company.getDescription();
        @Nullable final Address address = company.getAddress();
        addressId = address != null ? address.getId() : null;
    }

}
