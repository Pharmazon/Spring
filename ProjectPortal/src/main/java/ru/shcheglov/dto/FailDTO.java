package ru.shcheglov.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public final class FailDTO extends ResultDTO {

    {
        setSuccess(false);
    }

    public FailDTO(Exception e) {
        setSuccess(false);
        setMessage(e.getMessage());
    }
    
}
