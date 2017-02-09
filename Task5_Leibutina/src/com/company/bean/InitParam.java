package com.company.bean;


public class InitParam {

    private String paramName;
    private String paramValue;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    @Override
    public String toString() {
        return "\n\tInitParam" +
                "\nparamName='" + paramName + '\'' +
                ", paramValue='" + paramValue + '\'';
    }
}