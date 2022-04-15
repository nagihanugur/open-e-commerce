package com.openecommerce.api.service;

import com.openecommerce.api.common.ServiceResult;
import com.openecommerce.api.dto.CategoryDto;
import com.openecommerce.api.entity.Category;
import com.openecommerce.api.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public ServiceResult<CategoryDto> save(CategoryDto category){
        ServiceResult<CategoryDto> serviceResult = new ServiceResult<>();

        if(category.getTitle() == null || category.getGender() == null){
           serviceResult.setSuccess(false);
           serviceResult.setErrorMessage("all fields required!");
           return serviceResult;
        }
        serviceResult.setData(new CategoryDto(categoryRepository.save(new Category(category))));
        serviceResult.setSuccess(true);
        return serviceResult;

    }

    public ServiceResult<Void> deleteCategoryById(UUID uuid){
           ServiceResult<Void> serviceResult = new ServiceResult<>();
        if (categoryRepository.existsById(uuid)){
            categoryRepository.deleteById(uuid);
            serviceResult.setSuccess(true);
            return serviceResult;
        }
        serviceResult.setErrorMessage("category not found by id");
        serviceResult.setSuccess(false);
        return serviceResult;
    }

    public ServiceResult<CategoryDto> getById(UUID uuid){
        ServiceResult<CategoryDto> serviceResult = new ServiceResult<>();
        Optional<Category> category = categoryRepository.findById(uuid);

        if (categoryRepository.existsById(uuid)){
            serviceResult.setData(new CategoryDto(category.get()));
            serviceResult.setSuccess(true);
            return serviceResult;
        }
        serviceResult.setSuccess(false);
        serviceResult.setErrorMessage("category not found by id");
        return serviceResult;

    }





    





}
