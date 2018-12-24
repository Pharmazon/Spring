package ru.shcheglov.repository.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.user.Company;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

@Repository(CompanyRepositoryImpl.NAME)
public class CompanyRepositoryImpl extends AbstractRepository<Company> implements CompanyRepository {

    @NotNull
    public static final String NAME = "companyRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Optional<Company> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("Company.deleteAll", Company.class)
                .executeUpdate();
    }

    @Override
    public Optional<Company> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(Company.class, id));
    }

    @Override
    public List<Company> findAll() {
        return getEntityManager()
                .createNamedQuery("Company.findAll", Company.class)
                .getResultList();
    }
}
