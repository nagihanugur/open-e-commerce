package com.openecommerce.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResult<T> {

    private T data;
    private boolean success = true;
    private String errorMessage;

    public ServiceResult(T data, boolean success, String errorMessage){

        this.data = data;
        this.errorMessage = errorMessage;
        this.success = success;
    }

    public ServiceResult(){}
    public ServiceResult(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
