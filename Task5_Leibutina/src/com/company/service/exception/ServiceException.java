package com.company.service.exception;

public class ServiceException extends Exception {

    public ServiceException(){
        super();
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(Exception e){
        super(e);
    }

    public ServiceException(String message, Throwable e){
        super(message, e);
    }
}