package com.codegym.casestudy4.service;

import com.codegym.casestudy4.dto.CategoryDto;
import com.codegym.casestudy4.dto.ProductDto;
import com.codegym.casestudy4.entity.Category;

public interface CategoryService {
    Category findCategoryById(long id);
    CategoryDto findCategoryByCustomerId(ProductDto productDto);
}
