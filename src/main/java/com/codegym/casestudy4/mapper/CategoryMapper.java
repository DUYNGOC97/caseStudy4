package com.codegym.casestudy4.mapper;

import com.codegym.casestudy4.dto.CategoryDto;
import com.codegym.casestudy4.entity.Category;

public class CategoryMapper {

    public static CategoryDto mapToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

}