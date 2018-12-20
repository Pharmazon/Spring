package ru.shcheglov.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.dto.CategoryDTO;
import ru.shcheglov.dto.ResultDTO;
import ru.shcheglov.model.Category;
import ru.shcheglov.service.CategoryService;

import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 17.12.2018
 */

@RestController
@RequestMapping("api/category")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "{id}", produces = "application/json")
    public CategoryDTO get(@PathVariable("id") final String id) {
        final Optional<Category> category = categoryService.get(id);
        return category.map(CategoryDTO::new).orElse(null);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO post(final CategoryDTO dto) {
        categoryService.save(dto);
        return new ResultDTO();
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO put(final CategoryDTO dto) {
        categoryService.save(dto);
        return new ResultDTO();
    }

    @DeleteMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO delete(final CategoryDTO dto) {
        categoryService.delete(dto);
        return new ResultDTO();
    }

}
