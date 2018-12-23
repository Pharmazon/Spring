package ru.shcheglov.controller.common;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import ru.shcheglov.dto.common.AbstractDTO;
import ru.shcheglov.model.common.AbstractEntity;
import ru.shcheglov.repository.common.CommonRepository;
import ru.shcheglov.service.common.CommonService;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

public interface CommonController<T extends AbstractEntity> {

    String entityList(Model model);

    String entityAdd(T entity, Model model);

    String entityCreate(T entity, BindingResult result);

    String entityEdit(Model model, String id);

    String entitySave(T entity, BindingResult result);

    String entityView(Model model, String id);

    String entityDelete(String id);

}
