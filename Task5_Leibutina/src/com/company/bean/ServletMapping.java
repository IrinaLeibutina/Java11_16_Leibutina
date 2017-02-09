package com.company.bean;

public class ServletMapping {
    private String servletName;
    private String urlPattern;

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    @Override
    public String toString() {
        return "ServletMapping\n" +
                " servletName='" + servletName + '\'' +
                ", urlPattern='" + urlPattern + '\'';
    }
}
