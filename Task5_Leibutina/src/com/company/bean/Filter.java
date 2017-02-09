package com.company.bean;

public class Filter {

    private String filterName;
    private String filterClass;
    private InitParam initParam;

    public Filter(){
       initParam = new InitParam();
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public void setFilterClass(String filterClass) {
        this.filterClass = filterClass;
    }

    public void setInitParam(InitParam initParam) {
        this.initParam = initParam;
    }

    @Override
    public String toString() {
        return "\n\tFilter" +
                "\nfilterName='" + filterName + '\'' +
                ", filterClass='" + filterClass + '\'' +
                ", initParam=" + initParam;

    }
}


