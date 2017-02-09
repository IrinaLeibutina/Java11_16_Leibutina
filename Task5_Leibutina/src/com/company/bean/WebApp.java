package com.company.bean;

import com.company.bean.*;

import java.util.ArrayList;
import java.util.List;

public class WebApp {

    private String displayName;
    private String id;
    private String version;

    private List<WelcomeFileList> welcomeFileLists;
    private List<Filter> filters;
    private List<FilterMapping> filterMappings;
    private List<Listener> listeners;
    private List<Servlet> servlets;
    private List<ServletMapping> servletMappings;
    private List<ErrorPage> errorPages;

    public WebApp() {
        welcomeFileLists = new ArrayList<>();
        filters = new ArrayList<>();
        filterMappings = new ArrayList<>();
        listeners = new ArrayList<>();
        servlets = new ArrayList<>();
        servletMappings = new ArrayList<>();
        errorPages = new ArrayList<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void addElementWelcomeFileLists(WelcomeFileList welcomeFileList) {
        welcomeFileLists.add(welcomeFileList);
    }

    public void addElementFilters(Filter filter) {
        filters.add(filter);
    }

    public void addElementFilterMappings(FilterMapping filterMapping) {
        filterMappings.add(filterMapping);
    }

    public void addElementListeners(Listener listener) {
        listeners.add(listener);
    }

    public void addElementServlets(Servlet servlet) {
        servlets.add(servlet);
    }

    public void addElementServletMappings(ServletMapping servletMapping) {
        servletMappings.add(servletMapping);
    }

    public void addElementErrorPages(ErrorPage errorPage) {
        this.errorPages.add(errorPage);
    }

    @Override
    public String toString() {
        return "\nWebApp\n" +
                "displayName='" + displayName + '\'' +
                ", id='" + id + '\'' +
                ", version='" + version + '\'' +
                ", \nwelcomeFileLists=" + welcomeFileLists +
                ", \nfilters=" + filters +
                ", \nfilterMappings=" + filterMappings +
                ", \nlisteners=" + listeners +
                ", \nservlets=" + servlets +
                ", \nservletMappings=" + servletMappings +
                ", \nerrorPages=" + errorPages;
    }
}
