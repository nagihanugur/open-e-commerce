package com.openecommerce.api.entity;


import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "file")
public class FileEntity extends BaseEntity {

    public FileEntity() {
    }

    public FileEntity(ZonedDateTime createdDate, ZonedDateTime lastUpdate,
                      UUID uuid, String fileName, String filePath, UUID entityId) {
        super(createdDate, lastUpdate);
        this.uuid = uuid;
        this.fileName = fileName;
        this.filePath = filePath;
        this.entityId = entityId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID uuid;

    @Column(name = "file_name", nullable = false, length = 55)
    private String fileName;

    @Column(name = "file_path", nullable = false)
    private String filePath;

    @Column(name = "entity_id", nullable = false)
    private UUID entityId;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
