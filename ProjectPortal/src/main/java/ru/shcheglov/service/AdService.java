package ru.shcheglov.service;

import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;
import ru.shcheglov.model.Company;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

public interface AdService extends BasicService<Ad> {

    List<Ad> get(Company company);

    List<Ad> get(Category category);

}
