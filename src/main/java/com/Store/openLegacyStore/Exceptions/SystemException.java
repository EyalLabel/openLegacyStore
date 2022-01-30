package com.Store.openLegacyStore.Exceptions;

public class SystemException extends Exception{
    public SystemException(ErrorMessage errorMessage) {
        super(errorMessage.getDescription());
    }
}
