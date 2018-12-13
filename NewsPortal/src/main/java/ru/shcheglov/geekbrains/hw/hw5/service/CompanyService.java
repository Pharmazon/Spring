package ru.shcheglov.geekbrains.hw.hw5.service;

import ru.shcheglov.geekbrains.hw.hw5.model.Ad;
import ru.shcheglov.geekbrains.hw.hw5.model.Company;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

public interface CompanyService extends BasicService<Company> {

    Company get(Ad ad);

}
