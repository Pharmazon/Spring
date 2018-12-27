package ru.shcheglov.dto;

import lombok.*;
import ru.shcheglov.dto.common.AbstractDTO;
import ru.shcheglov.model.user.Role;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexey Shcheglov
 * @version dated 21.12.2018
 */

@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleDTO extends AbstractDTO<Role> {

}
