package com.Store.openLegacyStore.Exceptions;

public enum ErrorMessage {

UPDATE_ERROR("Error updating product"),
    ID_NOT_FOUND("Id not found");


    private String description;

    ErrorMessage(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
