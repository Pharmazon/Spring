package ru.shcheglov.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.dto.AdDTO;
import ru.shcheglov.dto.CategoryDTO;
import ru.shcheglov.dto.ResultDTO;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;
import ru.shcheglov.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexey Shcheglov
 * @version dated 17.12.2018
 */

@RestController
@RequestMapping("api/categories")
public class CategoriesResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(produces = "application/json")
    public List<CategoryDTO> get() {
        final List<Category> ads = categoryService.getAll();
        return ads.stream()
                .map(CategoryDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO post(final CategoryDTO[] dtos) {
        for (final CategoryDTO dto : dtos) categoryService.save(dto);
        return new ResultDTO();
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO put(final CategoryDTO[] dtos) {
        for (final CategoryDTO dto : dtos) categoryService.save(dto);
        return new ResultDTO();
    }

    @DeleteMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO delete(final CategoryDTO[] dtos) {
        for (final CategoryDTO dto : dtos) categoryService.delete(dto);
        return new ResultDTO();
    }

}
