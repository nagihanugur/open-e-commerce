package com.openecommerce.api.service;

import com.openecommerce.api.common.ServiceResult;
import com.openecommerce.api.dto.CategoryDto;
import com.openecommerce.api.dto.mapper.CategoryMapper;
import com.openecommerce.api.entity.Category;
import com.openecommerce.api.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    private final ICategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = new CategoryMapper();
    }

    public ServiceResult<List<CategoryDto>> getAllCategories() {

        Iterable<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categoryMapper.toCategoryDtoList((List<Category>) categories);
        return new ServiceResult<>(categoryDtos);
    }

    public ServiceResult<Void> save(CategoryDto categoryDto) {
        ServiceResult<Void> serviceResult = new ServiceResult<>();

        if (categoryDto.getTitle() == null || categoryDto.getGender() == null || categoryDto.getDescription() == null) {
            serviceResult.setSuccess(false);
            serviceResult.setErrorMessage("all fields required!");
            return serviceResult;
        }
        categoryRepository.save(categoryMapper.toCategory(categoryDto));
        return serviceResult;
    }

    public ServiceResult<Void> deleteCategoryById(UUID uuid) {
        ServiceResult<Void> serviceResult = new ServiceResult<>();
        if (categoryRepository.existsById(uuid)) {
            categoryRepository.deleteById(uuid);
            serviceResult.setSuccess(true);
            return serviceResult;
        }
        serviceResult.setErrorMessage("category not found by id");
        serviceResult.setSuccess(false);
        return serviceResult;
    }

    public ServiceResult<CategoryDto> getById(UUID uuid) {
        ServiceResult<CategoryDto> serviceResult = new ServiceResult<>();
        Optional<Category> category = categoryRepository.findById(uuid);

        if (category.isPresent()) {
            serviceResult.setData(categoryMapper.toCategoryDto(category.get()));
            return serviceResult;
        }
        serviceResult.setSuccess(false);
        serviceResult.setErrorMessage("category not found by id");
        return serviceResult;

    }

}
