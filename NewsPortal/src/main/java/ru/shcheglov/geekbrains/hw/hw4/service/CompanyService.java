package ru.shcheglov.geekbrains.hw.hw4.service;

import ru.shcheglov.geekbrains.hw.hw4.entity.Ad;
import ru.shcheglov.geekbrains.hw.hw4.entity.Company;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

public interface CompanyService extends Service<Company> {

    Company get(Ad ad);

}
