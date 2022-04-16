package com.openecommerce.api.dto.mapper;

import com.openecommerce.api.dto.FileDto;
import com.openecommerce.api.entity.FileEntity;

import java.util.ArrayList;
import java.util.List;

public class FileMapper {

    public List<FileDto> toFileDtoList(List<FileEntity> files){
        List<FileDto> dtos = new ArrayList<>();
        files.forEach(fileEntity -> dtos.add(toFileDto(fileEntity)));
        return dtos;

    }

    public FileDto toFileDto(FileEntity file){
        FileDto fdto = new FileDto();
        fdto.setUuid(file.getUuid());
        fdto.setFilePath(file.getFilePath());
        return fdto;

    }
}
