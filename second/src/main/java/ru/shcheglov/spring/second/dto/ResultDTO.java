package ru.shcheglov.spring.second.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

/**
 * @author Alexey Shcheglov
 * @version dated 03.02.2019
 */

@Getter
@Setter
public class ResultDTO {

    @Nullable
    private Boolean success = true;

}
