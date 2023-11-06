package com.codegym.casestudy4.service.impl;

import com.codegym.casestudy4.dto.CategoryDto;
import com.codegym.casestudy4.dto.ProductDto;
import com.codegym.casestudy4.dto.UserDto;
import com.codegym.casestudy4.entity.Category;
import com.codegym.casestudy4.mapper.CategoryMapper;
import com.codegym.casestudy4.repository.CategoryRepository;
import com.codegym.casestudy4.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;
    @Override
    public Category findCategoryById(long id) {
        return categoryRepository.findCategoriesById(id);
    }
    public CategoryDto findCategoryByCustomerId(ProductDto productDto){
        Category category = productDto.getCategory();
        CategoryDto categoryDto = CategoryMapper.mapToDto(category);
        return categoryDto;
    }
}
