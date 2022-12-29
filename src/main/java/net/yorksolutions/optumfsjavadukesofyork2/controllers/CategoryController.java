package net.yorksolutions.optumfsjavadukesofyork2.controllers;

import net.yorksolutions.optumfsjavadukesofyork2.models.Category;
import net.yorksolutions.optumfsjavadukesofyork2.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryController {
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category create(@RequestBody Category categoryRequest) {
        return this.categoryService.create(categoryRequest);
    }

    @GetMapping
    public Iterable<Category> getCategories() {
        try {
            return categoryService.findAllCategories();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
