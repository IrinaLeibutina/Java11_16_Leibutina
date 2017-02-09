package com.company.service;

import com.company.bean.WebApp;
import com.company.service.exception.ServiceException;

public abstract class AbstractWebAppBuilder {

    WebApp webApp;
    public AbstractWebAppBuilder() {
        webApp = new WebApp();
    }

    public WebApp getWebApp() {
        return webApp;
    }

    abstract public void buildWebApp(String fileName) throws ServiceException;
}
