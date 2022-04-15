package com.openecommerce.api.dto;

import com.openecommerce.api.entity.FileEntity;

import java.util.UUID;

public class FileDto {

 private UUID uuid;

 private String filePath;


 public FileDto(UUID uuid, String filePath){

  this.uuid = uuid;

  this.filePath = filePath;
 }

 public FileDto(){}

 public FileDto(FileEntity fileEntity){}

 public UUID getUuid() {
  return uuid;
 }

 public void setUuid(UUID uuid) {
  this.uuid = uuid;
 }


 public String getFilePath() {
  return filePath;
 }

 public void setFilePath(String filePath) {
  this.filePath = filePath;
 }


}
