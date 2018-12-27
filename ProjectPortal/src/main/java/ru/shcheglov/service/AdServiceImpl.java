package ru.shcheglov.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.dto.AdDTO;
import ru.shcheglov.model.Ad;
import ru.shcheglov.repository.AdRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 27.12.2018
 */

@Service(AdServiceImpl.NAME)
@Transactional
public class AdServiceImpl implements AdService {

    @NotNull
    public static final String NAME = "adService";

    @Autowired
    private AdRepository adRepository;

    @Override
    public void saveOne(@NotNull final Ad entity) {
        adRepository.saveOne(entity);
    }

    @Override
    public void saveAll(@NotNull final List<Ad> list) {
        adRepository.saveAll(list);
    }

    @Override
    public void deleteOne(@NotNull final String id) {
        adRepository.deleteOne(id);
    }

    @Override
    public void deleteOne(@NotNull final Ad entity) {
        adRepository.deleteOne(entity);
    }

    @Override
    public void deleteAll() {
        adRepository.deleteAll();
    }

    @Override
    public Optional<Ad> getOne(@NotNull final String id) {
        return adRepository.findOne(id);
    }

    @Override
    public List<Ad> getAll() {
        return adRepository.findAll();
    }

    @Override
    public Ad updateOne(@NotNull final Ad entity) {
        return adRepository.updateOne(entity);
    }

    @Override
    public void saveOne(@NotNull final AdDTO dto) {

    }

    @Override
    public void deleteOne(@NotNull final AdDTO dto) {

    }
}
