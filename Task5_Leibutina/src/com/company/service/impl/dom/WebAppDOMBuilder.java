package com.company.service.impl.dom;

import com.company.service.AbstractWebAppBuilder;
import com.company.bean.WebApp;
import com.company.service.exception.ServiceException;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;

public class WebAppDOMBuilder extends AbstractWebAppBuilder {

    private WebApp webApp;

    WebAppDOMBuilder() {
        webApp = new WebApp();
    }

    public void buildWebApp(String path) throws ServiceException {
        DOMParser parser = new DOMParser();
        try {
            parser.parse(new InputSource(path));
            WebAppDOM webAppDOM = new WebAppDOM(parser);
            webApp = webAppDOM.parse();
        } catch (SAXException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        } catch (IOException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    public WebApp getWebApp() {
        return webApp;
    }
}


