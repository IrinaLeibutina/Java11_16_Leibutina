package com.company.nodes;

public class FilterMapping {

    private String filterName;
    private String urlPattern;
    private String dispatcher;

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public String getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(String dispatcher) {
        this.dispatcher = dispatcher;
    }

    /// ?????
    @Override
    public String toString() {
        return "FilterMapping{" +
                "filterName='" + filterName + '\'' +
                ", urlPattern='" + urlPattern + '\'' +
                ", dispatcher='" + dispatcher + '\'' +
                '}';
    }
}
