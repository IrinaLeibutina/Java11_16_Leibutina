package com.company;
import com.company.nodes.*;

import java.util.ArrayList;
import java.util.List;

public class WebApp {

    private String displayName;
    private List<WelcomeFileList> welcomeFileLists;
    private List<Filter> filters;
    private List<FilterMapping> filterMappings;
    private List <Listener> listeners;
    private List <Servlet> servlets;
    private List<ServletMapping> servletMappings;
    private List<ErrorPage> errorPages;

    WebApp(){
        welcomeFileLists = new ArrayList<>();
        filters = new ArrayList<>();
        filterMappings = new ArrayList<>();
        listeners = new ArrayList<>();
        servlets = new ArrayList<>();
        servletMappings = new ArrayList<>();
        errorPages = new ArrayList<>();
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<WelcomeFileList> getWelcomeFileLists() {
        return welcomeFileLists;
    }

    public void addElementWelcomeFileLists(WelcomeFileList welcomeFileList) {
        welcomeFileLists.add(welcomeFileList);
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void addElementFilters(Filter filter) {
        filters.add(filter);
    }

    public List<FilterMapping> getFilterMappings() {
        return filterMappings;
    }

    public void addElementFilterMappings(FilterMapping filterMapping) {
      filterMappings.add(filterMapping);
    }

// TODO for this element
   public List<Listener> getListeners() {
      return listeners;
   }

   public void setListeners(List<Listener> listeners) {
       this.listeners = listeners;
   }

    public void addElementListeners(Listener listener) {
       listeners.add(listener);
    }

  public List<Servlet> getServlets() {
      return servlets;
  }

  public void addElementServlets(Servlet servlet) {
      servlets.add(servlet);
  }

  public List<ServletMapping> getServletMappings() {
      return servletMappings;
  }

  public void addElementServletMappings(ServletMapping servletMapping) {
      servletMappings.add(servletMapping);
  }

   public List<ErrorPage> getErrorPages() {
       return errorPages;
   }

   public void addElementErrorPages(ErrorPage errorPage) {
       this.errorPages.add(errorPage);
   }
}
