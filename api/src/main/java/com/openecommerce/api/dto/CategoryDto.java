package com.openecommerce.api.dto;

import com.openecommerce.api.entity.Category;
import com.openecommerce.api.enums.Gender;

import java.util.List;
import java.util.UUID;

public class CategoryDto {

      private UUID uuid;
      private String title;
      private List<Category> children;
    private Gender gender;

      public CategoryDto(UUID uuid, String title, List<Category> children, Gender gender){

          this.uuid = uuid;
          this.title = title;
          this.children = children;
          this.gender = gender;

      }

      public CategoryDto(Category category){}

    public CategoryDto() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }
}
