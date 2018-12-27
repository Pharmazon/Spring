package ru.shcheglov.dto;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import ru.shcheglov.dto.common.AbstractDTO;
import ru.shcheglov.model.user.User;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends AbstractDTO<User> {

    @NotNull
    private String login;

    public UserDTO(@NotNull final User user) {
        login = user.getLogin();
    }

}
