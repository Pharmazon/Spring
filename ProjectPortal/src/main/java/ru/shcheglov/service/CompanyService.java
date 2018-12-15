package ru.shcheglov.service;

import ru.shcheglov.dto.CompanyDTO;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Company;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

public interface CompanyService extends BasicService<Company, CompanyDTO> {

    Company get(Ad ad);

}
