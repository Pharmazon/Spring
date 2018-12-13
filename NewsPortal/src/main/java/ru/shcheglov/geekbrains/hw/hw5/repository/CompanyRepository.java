package ru.shcheglov.geekbrains.hw.hw5.repository;

import ru.shcheglov.geekbrains.hw.hw5.model.Ad;
import ru.shcheglov.geekbrains.hw.hw5.model.Company;

/**
 * @author Alexey Shcheglov
 * @version dated 07.12.2018
 */

public interface CompanyRepository extends BasicRepository<Company> {

    Company findOneByAd(Ad ad);

}
