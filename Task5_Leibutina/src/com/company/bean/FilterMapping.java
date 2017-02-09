package com.company.bean;

public class FilterMapping {

    private String filterName;
    private String urlPattern;
    private String dispatcher;

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public void setDispatcher(String dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public String toString() {
        return "\nFilterMapping\n" +
                "filterName='" + filterName + '\'' +
                ", urlPattern='" + urlPattern + '\'' +
                ", dispatcher='" + dispatcher + '\'';
    }
}

