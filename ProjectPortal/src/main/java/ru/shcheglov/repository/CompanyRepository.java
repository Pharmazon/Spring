package ru.shcheglov.repository;

import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Company;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

public interface CompanyRepository extends BasicRepository<Company> {

    Company findOneByAd(Ad ad);

    List<Ad> findAllAds(Company model);

}
