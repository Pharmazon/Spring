package ru.shcheglov.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.shcheglov.dto.common.AbstractDTO;
import ru.shcheglov.model.Ad;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexey Shcheglov
 * @version dated 27.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XmlRootElement
public class AdDTO extends AbstractDTO<Ad> {
}
