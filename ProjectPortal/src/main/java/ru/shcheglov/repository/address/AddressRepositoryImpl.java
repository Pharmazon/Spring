package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.Address;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(AddressRepositoryImpl.NAME)
public class AddressRepositoryImpl extends AbstractRepository<Address> implements AddressRepository {

    @NotNull
    public static final String NAME = "addressRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Optional<Address> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("Address.deleteAll", Address.class)
                .executeUpdate();
    }

    @Override
    public Optional<Address> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(Address.class, id));
    }

    @Override
    public List<Address> findAll() {
        return getEntityManager()
                .createNamedQuery("Address.findAll", Address.class)
                .getResultList();
    }
}
