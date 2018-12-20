package ru.shcheglov.repository.eav;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.eav.AdAttributeValue;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

@Repository(AdAttributeValueRepository.NAME)
public class AdAttributeValueRepository extends AbstractRepository<AdAttributeValue>
        implements BasicRepository<AdAttributeValue> {

    @NotNull
    public static final String NAME = "adAttributeValueRepository";

}
