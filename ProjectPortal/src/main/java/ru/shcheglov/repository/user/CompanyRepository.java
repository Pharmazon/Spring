package ru.shcheglov.repository.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.user.Company;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

@Repository(CompanyRepository.NAME)
public class CompanyRepository extends AbstractRepository<Company> implements BasicRepository<Company> {

    @NotNull
    public static final String NAME = "companyRepository";

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

    public List<Ad> findAllAds(@NotNull final Company company) {
        return null;
//        return entityManager
//                .createNamedQuery("Company.findAllAds", Ad.class)
//                .setParameter("company", company)
//                .getResultList();
    }

}
