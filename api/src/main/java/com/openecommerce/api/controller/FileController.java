package com.openecommerce.api.controller;

import com.openecommerce.api.common.ServiceResult;
import com.openecommerce.api.dto.FileDto;
import com.openecommerce.api.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/files")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    public ResponseEntity<ServiceResult<List<FileDto>>> fetchFiles(){
        return new ResponseEntity<>(fileService.getAllFiles(), HttpStatus.OK);
    }
}
