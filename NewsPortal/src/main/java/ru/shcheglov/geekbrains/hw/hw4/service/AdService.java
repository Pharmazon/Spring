package ru.shcheglov.geekbrains.hw.hw4.service;

import ru.shcheglov.geekbrains.hw.hw4.entity.Ad;
import ru.shcheglov.geekbrains.hw.hw4.entity.Category;
import ru.shcheglov.geekbrains.hw.hw4.entity.Company;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

public interface AdService extends Service<Ad> {

    List<Ad> get(Company company);

    List<Ad> get(Category category);

}
