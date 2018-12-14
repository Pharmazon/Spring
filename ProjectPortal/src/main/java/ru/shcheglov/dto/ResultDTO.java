package ru.shcheglov.dto;

import org.jetbrains.annotations.Nullable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexey Shcheglov
 * @version dated 14.12.2018
 */

@XmlRootElement
public abstract class ResultDTO {

    @Nullable
    private Boolean success = true;

    @Nullable
    private String message = "";

    public ResultDTO() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(final Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
