package com.openecommerce.api.dto.mapper;

import com.openecommerce.api.dto.CategoryDto;
import com.openecommerce.api.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public List<CategoryDto> toCategoryDtoList(List<Category> categories) {
        List<CategoryDto> dtos = new ArrayList<>();
        categories.forEach(category -> dtos.add(toCategoryDto(category)));
        return dtos;
    }

    public Category toCategory(CategoryDto dto) {
        Category category = new Category();
        category.setId(dto.getId());
        category.setTitle(dto.getTitle());
        category.setDescription(dto.getDescription());
        category.setChildren(getCategoryChildren(dto.getChildren()));
        category.setGender(dto.getGender());
        return category;
    }

    public List<Category> getCategoryChildren(List<CategoryDto> categoryDtos) {
        return categoryDtos.stream().map(categoryDto ->
                new Category(categoryDto.getId(), categoryDto.getTitle(),
                        categoryDto.getDescription(), categoryDto.getGender())).toList();
    }

    public CategoryDto toCategoryDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setTitle(category.getTitle());
        dto.setGender(category.getGender());
        dto.setDescription(category.getDescription());
        dto.setChildren(category.getChildren());
        return dto;
    }
}
