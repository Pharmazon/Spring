package ru.shcheglov.geekbrains.hw.hw5.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.geekbrains.hw.hw5.model.Ad;
import ru.shcheglov.geekbrains.hw.hw5.model.Company;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

@Repository(CompanyRepositoryImpl.NAME)
public class CompanyRepositoryImpl extends AbstractRepository<Company> implements CompanyRepository {

    @NotNull
    public static final String NAME = "companyRepository";

    @Override
    public void save(@NotNull final Company entity) {
        super.save(entity);
    }

    @Override
    public void delete(@NotNull final String id) {
        final Optional<Company> company = findOne(id);
        company.ifPresent(this::delete);
    }

    @Override
    public void delete(@NotNull final Company entity) {
        super.delete(entity);
    }

    @Override
    public void deleteAll() {
        entityManager.createNamedQuery("Company.deleteAll", Company.class);
    }

    @Override
    public Optional<Company> findOne(@NotNull final String id) {
        return Optional.of(entityManager.find(Company.class, id));
    }

    @Override
    public List<Company> findAll() {
        return entityManager
                .createNamedQuery("Company.findAll", Company.class)
                .getResultList();
    }

    @Override
    public Company update(@NotNull final Company entity) {
        return super.update(entity);
    }

    @Override
    public Company findOneByAd(@NotNull final Ad ad) {
        @NotNull final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        @NotNull final CriteriaQuery<Company> query = builder.createQuery(Company.class);
        @NotNull final Root<Company> root = query.from(Company.class);
        @NotNull final Join<Company, Ad> join = root.join("ad", JoinType.INNER);
        @NotNull final Path<Ad> pathAd = join.get("ad");
        @NotNull final ParameterExpression<Ad> parameterAd = builder.parameter(Ad.class, "ad");
        @NotNull final Predicate predicateByAd = builder.equal(pathAd, parameterAd);
        query.where(predicateByAd);
        @NotNull final TypedQuery<Company> typedQuery = entityManager.createQuery(query);
        typedQuery.setParameter("ad", ad);
        return typedQuery.getSingleResult();
    }

}
