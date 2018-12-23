package ru.shcheglov.controller.common;

import ru.shcheglov.dto.common.AbstractDTO;
import ru.shcheglov.model.common.AbstractEntity;

/**
 * @author Alexey Shcheglov
 * @version dated 21.12.2018
 */

public interface CommonResource<
        T extends AbstractEntity,
        D extends AbstractDTO<T>> {

    D get(String id);

    D post(final D dto);

    D put(final D dto);

    D delete(final D dto);

}
