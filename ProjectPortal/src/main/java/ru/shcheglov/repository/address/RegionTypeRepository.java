package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.RegionType;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(RegionTypeRepository.NAME)
public class RegionTypeRepository extends AbstractRepository<RegionType> implements BasicRepository<RegionType> {

    @NotNull
    public static final String NAME = "regionTypeRepository";

}
