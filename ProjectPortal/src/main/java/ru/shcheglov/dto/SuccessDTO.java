package ru.shcheglov.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexey Shcheglov
 * @version dated 14.12.2018
 */

@XmlRootElement
public final class SuccessDTO extends ResultDTO {

    {
        setSuccess(true);
    }

}
