package ru.shcheglov.geekbrains.hw.hw5.service;

import ru.shcheglov.geekbrains.hw.hw5.model.Ad;
import ru.shcheglov.geekbrains.hw.hw5.model.Category;
import ru.shcheglov.geekbrains.hw.hw5.model.Company;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

public interface AdService extends BasicService<Ad> {

    List<Ad> get(Company company);

    List<Ad> get(Category category);

}
