package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.StreetName;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(StreetNameRepository.NAME)
public class StreetNameRepository extends AbstractRepository<StreetName> implements BasicRepository<StreetName> {

    @NotNull
    public static final String NAME = "streetNameRepository";

}
