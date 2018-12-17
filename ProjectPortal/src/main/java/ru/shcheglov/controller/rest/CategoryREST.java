package ru.shcheglov.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.dto.CategoryDTO;
import ru.shcheglov.dto.FailDTO;
import ru.shcheglov.dto.ResultDTO;
import ru.shcheglov.dto.SuccessDTO;
import ru.shcheglov.model.Category;
import ru.shcheglov.service.CategoryService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Alexey Shcheglov
 * @version dated 17.12.2018
 */

@RestController
@RequestMapping("CategoryService")
public class CategoryREST {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "ping", produces = "application/json")
    public ResultDTO ping() {
        return new ResultDTO();
    }

    @GetMapping(value = "createCategory", produces = "application/json")
    public CategoryDTO createCategory() {
        try {
            final Category category = new Category();
            category.setName("");
            categoryService.save(category);
            return new CategoryDTO(category);
        } catch (final Exception e) {
            return null;
        }
    }

    @GetMapping(value = "getCategoryList", produces = "application/json")
    public List<CategoryDTO> getCategoryList() {
        try {
            final List<Category> categories = categoryService.getAll();
            return categories.stream()
                    .map(CategoryDTO::new)
                    .collect(Collectors.toList());
        } catch (final Exception e) {
            return Collections.emptyList();
        }
    }

    @GetMapping(value = "getCategoryById/{id}", produces = "application/json")
    public CategoryDTO getCategoryById(@PathVariable("id") final String id) {
        try {
            final Optional<Category> category = categoryService.get(id);
            return category.map(CategoryDTO::new).orElse(null);
        } catch (final Exception e) {
            return null;
        }
    }

    @PostMapping(value = "mergeCategory", produces = "application/json", consumes = "application/json")
    public ResultDTO mergeCategory(final CategoryDTO dto) {
        try {
            categoryService.save(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @PostMapping(value = "mergeCategories", produces = "application/json", consumes = "application/json")
    public ResultDTO mergeCategories(final CategoryDTO[] dtos) {
        try {
            for (final CategoryDTO dto : dtos) categoryService.save(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @GetMapping(value = "deleteCategoryById/{id}", produces = "application/json")
    public ResultDTO deleteCategoryById(@PathVariable("id") final String id) {
        try {
            categoryService.delete(id);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @PostMapping(value = "deleteCategory", produces = "application/json", consumes = "application/json")
    public ResultDTO deleteCategory(final CategoryDTO dto) {
        try {
            categoryService.delete(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @DeleteMapping(value = "deleteCategories", produces = "application/json")
    public ResultDTO deleteCategories(final CategoryDTO[] dtos) {
        try {
            for (final CategoryDTO dto : dtos) categoryService.delete(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

}
