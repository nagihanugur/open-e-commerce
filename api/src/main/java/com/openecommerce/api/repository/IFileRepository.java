package com.openecommerce.api.repository;

import com.openecommerce.api.entity.FileEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IFileRepository extends CrudRepository<FileEntity, UUID> {

}
