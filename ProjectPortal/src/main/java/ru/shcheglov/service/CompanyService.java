package ru.shcheglov.service;

import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Company;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

public interface CompanyService extends BasicService<Company> {

    Company get(Ad ad);

}
