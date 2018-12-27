package ru.shcheglov.dto;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.dto.common.AbstractDTO;
import ru.shcheglov.model.user.Company;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.model.user.User;
import ru.shcheglov.model.user.UserProfile;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

/**
 * @author Alexey Shcheglov
 * @version dated 24.12.2018
 */

@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserProfileDTO extends AbstractDTO<UserProfile> {

    @Nullable
    private String email;

    @NotNull
    private LocalDateTime dateRegistered;

    @Nullable
    private String firstName;

    @Nullable
    private String lastName;

    @Nullable
    private String phone;

    @Nullable
    private String companyId;

    @NotNull
    private String roleId;

    @NotNull
    private String userId;

    public UserProfileDTO(@NotNull final UserProfile userProfile) {
        email = userProfile.getEmail();
        dateRegistered = userProfile.getDateRegistered();
        firstName = userProfile.getFirstName();
        lastName = userProfile.getLastName();
        phone = userProfile.getPhone();
        @Nullable final Company company = userProfile.getCompany();
        companyId = company != null ? company.getId() : null;
        @NotNull final Role role = userProfile.getRole();
        roleId = role.getId();
        @NotNull final User user = userProfile.getUser();
        userId = user.getId();
    }
}
