package ru.shcheglov.geekbrains.hw.hw4.repository;

import ru.shcheglov.geekbrains.hw.hw4.entity.Ad;
import ru.shcheglov.geekbrains.hw.hw4.entity.Company;

/**
 * @author Alexey Shcheglov
 * @version dated 07.12.2018
 */

public interface CompanyRepository extends Repository<Company> {

    Company findOneByAd(Ad ad);

}
