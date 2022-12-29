package net.yorksolutions.optumfsjavadukesofyork2.services;

import net.yorksolutions.optumfsjavadukesofyork2.models.Category;
import net.yorksolutions.optumfsjavadukesofyork2.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(Category categoryRequest) {
        return this.categoryRepository.save(categoryRequest);
    }

    public Iterable<Category> findAllCategories(){
        return categoryRepository.findAll();
    }

}
