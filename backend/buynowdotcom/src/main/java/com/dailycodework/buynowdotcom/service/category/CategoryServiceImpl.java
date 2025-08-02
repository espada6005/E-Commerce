package com.dailycodework.buynowdotcom.service.category;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dailycodework.buynowdotcom.model.Category;
import com.dailycodework.buynowdotcom.repository.CategoryRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    
    private final CategoryRepository categoryRepository;
    
    @Override
    public Category addCategory(Category category) {
        // Implementation for adding a category
        return Optional.of(category)
                .filter(c -> !categoryRepository.existsByName(c.getName()))
                .map(categoryRepository::save)
                .orElseThrow(() -> new EntityExistsException(category.getName() + " already exists!"));
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        // Implementation for updating a category
        return Optional.ofNullable(findCategoryById(categoryId))
                .map(oldCategory -> {
                    oldCategory.setName(category.getName());
                    return categoryRepository.save(oldCategory);
                }).orElseThrow(() -> new EntityNotFoundException("Category not found!"));
    }

    @Override
    public void deleteCategory(Long categoryId) {
        // Implementation for deleting a category
        categoryRepository.findById(categoryId)
                .ifPresentOrElse(categoryRepository::delete, () -> {
                    throw new EntityNotFoundException("Category not found!");
                });
    }

    @Override
    public List<Category> getAllCategories() {
        // Implementation for retrieving all categories
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryByName(String name) {
        // Implementation for finding a category by name
        return categoryRepository.findByName(name);
    }

    @Override
    public Category findCategoryById(Long categoryId) {
        // Implementation for finding a category by ID
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found!"));
    }

}
