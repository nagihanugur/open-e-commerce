package com.opencommerce.api.entity;


import java.time.ZonedDateTime;

public class BaseEntity {

    public BaseEntity() {
    }

    public BaseEntity(ZonedDateTime createdDate, ZonedDateTime lastUpdate) {
        this.createdDate = createdDate;
        this.lastUpdate = lastUpdate;
    }

    private ZonedDateTime createdDate;
    private ZonedDateTime lastUpdate;

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(ZonedDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
