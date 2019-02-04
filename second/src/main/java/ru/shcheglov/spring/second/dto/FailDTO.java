package ru.shcheglov.spring.second.dto;

/**
 * @author Alexey Shcheglov
 * @version dated 03.02.2019
 */

public class FailDTO extends ResultDTO {

    {
        setSuccess(false);
    }

    public FailDTO(Exception e) {
        setSuccess(false);
    }

}
