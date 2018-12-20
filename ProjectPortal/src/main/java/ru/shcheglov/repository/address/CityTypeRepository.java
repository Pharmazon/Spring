package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.CityType;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(CityTypeRepository.NAME)
public class CityTypeRepository extends AbstractRepository<CityType> implements BasicRepository<CityType> {

    @NotNull
    public static final String NAME = "cityTypeRepository";

}
