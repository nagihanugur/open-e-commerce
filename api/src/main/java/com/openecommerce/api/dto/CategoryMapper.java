package com.openecommerce.api.dto;

import com.openecommerce.api.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public List<CategoryDto> toCategoryDtoList(List<Category> categories){
        List<CategoryDto> dtos = new ArrayList<>();
        categories.forEach(category -> dtos.add(toCategoryDto(category)));
        return dtos;
    }

    public CategoryDto toCategoryDto(Category category){
        CategoryDto dto = new CategoryDto();
        dto.setUuid(category.getUuid());
        dto.setTitle(category.getTitle());
    //  List<String> categories = new ArrayList<>();
     //  category.getChildren().forEach(child -> categories.add(child.getTitle()));
        dto.setChildren(category.getChildren());

        return dto;
    }
}
