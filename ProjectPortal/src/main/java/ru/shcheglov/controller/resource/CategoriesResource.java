package ru.shcheglov.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.dto.CategoryDTO;
import ru.shcheglov.dto.ResultDTO;
import ru.shcheglov.model.Category;
import ru.shcheglov.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexey Shcheglov
 * @version dated 27.12.2018
 */

@RestController
@RequestMapping("api/categories")
public class CategoriesResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(produces = "application/json")
    public List<CategoryDTO> get() {
        final List<Category> entities = categoryService.getAll();
        return entities.stream()
                .map(CategoryDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO post(final CategoryDTO[] dtos) {
        for (final CategoryDTO dto : dtos) categoryService.saveOne(dto);
        return new ResultDTO();
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO put(final CategoryDTO[] dtos) {
        for (final CategoryDTO dto : dtos) categoryService.saveOne(dto);
        return new ResultDTO();
    }

    @DeleteMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO delete(final CategoryDTO[] dtos) {
        for (final CategoryDTO dto : dtos) categoryService.deleteOne(dto);
        return new ResultDTO();
    }
}
