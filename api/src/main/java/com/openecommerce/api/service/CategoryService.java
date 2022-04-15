package com.openecommerce.api.service;

import com.openecommerce.api.common.ServiceResult;
import com.openecommerce.api.dto.CategoryDto;
import com.openecommerce.api.entity.Category;
import com.openecommerce.api.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public ServiceResult<List<CategoryDto>> getAllCategories(){

        Iterable<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        categories.forEach(category -> categoryDtos.add(new CategoryDto(category)));

        return new ServiceResult<List<CategoryDto>>(categoryDtos);
    }





    





}
