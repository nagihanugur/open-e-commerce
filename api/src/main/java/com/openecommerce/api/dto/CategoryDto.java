package com.openecommerce.api.dto;

import com.openecommerce.api.entity.Category;

import java.util.List;
import java.util.UUID;

public class CategoryDto {

      private UUID uuid;
      private String title;
      private List<Category> children;

      public CategoryDto(UUID uuid, String title, List<Category> children){

          this.uuid = uuid;
          this.title = title;
          this.children = children;
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
