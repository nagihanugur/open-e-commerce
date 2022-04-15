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
    public  ResponseEntity<ServiceResult<CategoryDto>> addCategory(@RequestBody CategoryDto category){
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }

    @DeleteMapping("/{categoryUuid}")
    public ResponseEntity<ServiceResult<Void>> deleteCategory(@PathVariable UUID uuid){
        return new ResponseEntity<>(categoryService.deleteCategoryById(uuid), HttpStatus.OK);
    }

    @GetMapping("/{categoryUuid}")
    public ResponseEntity<ServiceResult<CategoryDto>> getCategoryById(UUID uuid){
        return new ResponseEntity<>(categoryService.getById(uuid), HttpStatus.OK);
    }
}
