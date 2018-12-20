package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.Address;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(AddressRepository.NAME)
public class AddressRepository extends AbstractRepository<Address> implements BasicRepository<Address> {

    @NotNull
    public static final String NAME = "addressRepository";

    @Override
    public void save(Address model) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(Address model) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<Address> findOne(String id) {
        return Optional.empty();
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public Address update(Address model) {
        return null;
    }
}
