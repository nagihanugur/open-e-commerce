package com.openecommerce.api.repository;

import com.openecommerce.api.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICategoryRepository extends CrudRepository<Category, UUID> {

}
