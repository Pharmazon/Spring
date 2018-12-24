package ru.shcheglov.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XmlRootElement
public final class CompanyDTO extends AbstractDTO<Company> {

    @Nullable
    private String description;

    @Nullable
    private Address address;

    public CompanyDTO(@NotNull final Company company) {
        description = company.getDescription();
        address = company.getAddress();
    }

}
