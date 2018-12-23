package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.repository.basic.AbstractRepository;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(AddressRepository.NAME)
public class AddressRepository extends AbstractRepository {

    @NotNull
    public static final String NAME = "addressRepository";

}
