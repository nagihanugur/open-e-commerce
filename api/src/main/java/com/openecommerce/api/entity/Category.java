package com.openecommerce.api.entity;


import com.openecommerce.api.dto.CategoryDto;
import com.openecommerce.api.enums.Gender;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "category")
public class Category extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID uuid;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "description",length = 1000)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="parentCategory", orphanRemoval = true)
    private List<Category> children = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parentCategory;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "gender")
    private Gender gender;

    public Category() {
    }

    public Category(ZonedDateTime createdDate, ZonedDateTime lastUpdate,
                    UUID uuid, String title, String description,
                    List<Category> children, Category parentCategory, Gender gender) {
        super(createdDate, lastUpdate);
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.children = children;
        this.parentCategory = parentCategory;
        this.gender = gender;
    }

    public Category(CategoryDto category) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
