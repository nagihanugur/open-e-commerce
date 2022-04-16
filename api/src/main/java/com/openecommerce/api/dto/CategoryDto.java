package com.openecommerce.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.openecommerce.api.entity.Category;
import com.openecommerce.api.enums.Gender;

import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {

    private UUID id;
    private String title;

    private String description;
    private List<CategoryDto> children;
    private Gender gender;

    public CategoryDto(UUID id, String title, String description, List<CategoryDto> children, Gender gender) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.children = children;
        this.gender = gender;
    }

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.description = category.getDescription();
        this.gender = category.getGender();
    }

    public CategoryDto() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CategoryDto> getChildren() {
        return children;
    }
    public void setChildren(List<Category> children) {
        this.children = children.stream().map(CategoryDto::new).toList();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
