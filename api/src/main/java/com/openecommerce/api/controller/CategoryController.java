package com.openecommerce.api.controller;

import com.openecommerce.api.common.ServiceResult;
import com.openecommerce.api.dto.CategoryDto;
import com.openecommerce.api.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<ServiceResult<List<CategoryDto>>> fetchCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<ServiceResult<Void>> addCategory(@RequestBody CategoryDto category){
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }

    @DeleteMapping("/{categoryUuid}")
    public ResponseEntity<ServiceResult<Void>> deleteCategory(@PathVariable UUID categoryUuid){
        return new ResponseEntity<>(categoryService.deleteCategoryById(categoryUuid), HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<ServiceResult<CategoryDto>> getCategoryById(UUID categoryId){
        return new ResponseEntity<>(categoryService.getById(categoryId), HttpStatus.OK);
    }
}
