package com.company.bean;

public class ErrorPage {

    private String errorCode;
    private String location;
    private String exceptionType;

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public String toString() {
        if(errorCode==null){
            return "\nErrorPage \nlocation='" + location + '\'' +
                    ", exceptionType='" + exceptionType + '\'';

        } else return  "\nErrorPage\n" +
                "errorCode='" + errorCode + '\'' +
                ", location='" + location + '\'';
    }
}
