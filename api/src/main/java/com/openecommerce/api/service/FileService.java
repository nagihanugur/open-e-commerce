package com.openecommerce.api.service;

import com.openecommerce.api.common.ServiceResult;
import com.openecommerce.api.dto.CategoryDto;
import com.openecommerce.api.dto.FileDto;
import com.openecommerce.api.entity.FileEntity;
import com.openecommerce.api.repository.IFileRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    private final IFileRepository fileRepository;

    public FileService(IFileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public ServiceResult<List<FileDto>> getAllFiles(){

        Iterable<FileEntity> files = fileRepository.findAll();
        List<FileDto> fileDtos = new ArrayList<>();
        files.forEach(fileEntity -> fileDtos.add(new FileDto(fileEntity)));

       return  new ServiceResult<List<FileDto>>(fileDtos);
    }
}
