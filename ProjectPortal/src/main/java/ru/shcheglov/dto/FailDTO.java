package ru.shcheglov.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexey Shcheglov
 * @version dated 14.12.2018
 */

@XmlRootElement
public final class FailDTO extends ResultDTO {

    {
        setSuccess(false);
    }

    public FailDTO(Exception e) {
        setSuccess(false);
        setMessage(e.getMessage());
    }
    
}
