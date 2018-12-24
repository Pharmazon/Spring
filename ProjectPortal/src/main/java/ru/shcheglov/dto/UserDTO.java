package ru.shcheglov.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.shcheglov.dto.common.AbstractDTO;
import ru.shcheglov.model.user.User;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XmlRootElement
public class UserDTO extends AbstractDTO<User> {

    @NotNull
    private String login;

    public UserDTO(@NotNull final User user) {
        login = user.getLogin();
    }

}
