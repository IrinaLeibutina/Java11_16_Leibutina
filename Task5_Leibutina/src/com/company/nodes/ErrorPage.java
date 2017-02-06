package com.company.nodes;

public class ErrorPage {

    private String errorCode;
    private String location;
    private String exceptionType;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public String toString() {
        if(errorCode==null){
            return "ErrorPage {location='" + location + '\'' +
                    ", exceptionType='" + exceptionType + '\'' +
                    '}';

        } else return  "ErrorPage{" +
                "errorCode='" + errorCode + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
