package com.company.bean;

public class Servlet {

    private String servletName;
    private String servletClass;
private InitParam initParam;

    public Servlet(){
        initParam = new InitParam();
    }
    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public void setServletClass(String servletClass) {
        this.servletClass = servletClass;
    }

    public void setInitParam(InitParam initParam) {
        this.initParam = initParam;
    }

    @Override
    public String toString() {
        return "\n\tServlet" +
                " servletName='" + servletName + '\'' +
                ", servletClass='" + servletClass + '\'';
    }
}
