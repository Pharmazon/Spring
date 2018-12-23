package ru.shcheglov.service.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.dto.CompanyDTO;
import ru.shcheglov.dto.common.AbstractDTO;
import ru.shcheglov.model.user.Company;
import ru.shcheglov.repository.user.CompanyRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 23.12.2018
 */

@Service(CompanyServiceImpl.NAME)
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @NotNull
    public static final String NAME = "companyService";

    @Autowired
    private CompanyRepository repository;

    @Override
    public void saveOne(Company entity) {
        repository.saveOne(entity);
    }

    @Override
    public void saveAll(@NotNull final List<Company> list) {
        for (Company t : list) repository.saveOne(t);
    }

    @Override
    public void deleteOne(String id) {
        repository.deleteOne(id);
    }

    @Override
    public void deleteOne(Company entity) {
        repository.deleteOne(entity);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Optional<Company> getOne(String id) {
        return repository.findOne(id);
    }

    @Override
    public List<Company> getAll() {
        return repository.findAll();
    }

    @Override
    public Company updateOne(Company entity) {
        return repository.updateOne(entity);
    }

    @Override
    public void deleteOne(CompanyDTO dto) {
        deleteOne(dto.getId());
    }

    @Override
    public void saveOne(CompanyDTO dto) {
        final Optional<Company> optional = getOne(dto.getId());
        if (!optional.isPresent()) {
            final Company entity = new Company();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());
            saveOne(entity);
        }
    }

}
