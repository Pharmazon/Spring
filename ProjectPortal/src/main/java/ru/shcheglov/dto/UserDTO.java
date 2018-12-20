package ru.shcheglov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.model.user.User;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class UserDTO extends AbstractDTO {

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private LocalDateTime dateRegistered;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    @Nullable
    private String companyId;

//    private List<Ad> ads;

    @NotNull
    private String roleId;

    public UserDTO(@NotNull final User user) {
        super.setId(user.getId());
        super.setName(user.getName());
        login = user.getLogin();
        password = user.getPassword();
        dateRegistered = user.getDateRegistered();
        phone = user.getPhone();
        email = user.getEmail();
//        @NotNull final Company company = user.getCompany();
//        companyId = company.getId();
        @NotNull final Role role = user.getRole();
        roleId = role.getId();
    }

}
