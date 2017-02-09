package com.company.service.impl.stax;

import com.company.bean.WebApp;
import com.company.bean.WebAppEnum;
import com.company.bean.*;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class WebAppStAX {

    private WebApp webApp;

    private WelcomeFileList welcomeFileList;
    private Filter filter;
    private FilterMapping filterMapping;
    private Listener listener;
    private Servlet servlet;
    private ServletMapping servletMapping;
    private ErrorPage errorPage;
    private InitParam initParam;

    private StringBuilder text;


    public WebApp process(XMLStreamReader reader) throws XMLStreamException {
        webApp = new WebApp();

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    webApp = startElement(webApp, reader);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    webApp = endElement(webApp, reader);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    text.append(reader.getText().trim());
                    break;
            }
        }
        return webApp;
    }

    private WebApp startElement(WebApp webApp, XMLStreamReader reader) {
        text = new StringBuilder();
        WebAppEnum tagName = WebAppEnum.valueOf(reader.getLocalName().toUpperCase().replace("-", "_"));
        switch (tagName) {

            case WEB_APP:
                webApp = new WebApp();
                webApp.setId(reader.getAttributeValue(null, "id"));
                webApp.setVersion(reader.getAttributeValue(null, "version"));
                break;
            case WELCOME_FILE_LIST:
                welcomeFileList = new WelcomeFileList();
                break;
            case FILTER:
                filter = new Filter();
                break;
            case INIT_PARAM:
                initParam = new InitParam();
                break;
            case FILTER_MAPPING:
                filterMapping = new FilterMapping();
                break;
            case LISTENER:
                listener = new Listener();
                break;
            case SERVLET:
                servlet = new Servlet();
                break;
            case SERVLET_MAPPING:
                servletMapping = new ServletMapping();
                break;
            case ERROR_PAGE:
                errorPage = new ErrorPage();
                break;
        }
        return webApp;
    }

    private WebApp endElement(WebApp webApp, XMLStreamReader reader) {
        WebAppEnum tagName = WebAppEnum.valueOf(reader.getLocalName().toUpperCase().replace("-", "_"));
        switch (tagName) {

            case DISPLAY_NAME:
                webApp.setDisplayName(text.toString());
                break;

            case WELCOME_FILE:
                welcomeFileList.addElementWelcomeFile(text.toString());
                break;

            case WELCOME_FILE_LIST:
                webApp.addElementWelcomeFileLists(welcomeFileList);
                welcomeFileList = null;
                break;

            case FILTER_NAME:
                if (filter != null) {
                    filter.setFilterName(text.toString());
                } else {
                    filterMapping.setFilterName(text.toString());
                }
                break;

            case FILTER_CLASS:
                filter.setFilterClass(text.toString());
                break;

            case PARAM_NAME:
                initParam.setParamName(text.toString());
                break;

            case PARAM_VALUE:
                initParam.setParamValue(text.toString());
                break;

            case INIT_PARAM:
                if (filter != null) {
                    filter.setInitParam(initParam);
                } else {
                    servlet.setInitParam(initParam);
                }
                initParam = null;
                break;

            case FILTER:
                webApp.addElementFilters(filter);
                filter = null;
                break;

            case URL_PATTERN:
                if (filterMapping != null) {
                    filterMapping.setUrlPattern(text.toString());
                } else {
                    servletMapping.setUrlPattern(text.toString());
                }
                break;

            case DISPATCHER:
                filterMapping.setDispatcher(text.toString());
                break;

            case FILTER_MAPPING:
                webApp.addElementFilterMappings(filterMapping);
                filterMapping = null;
                break;

            case LISTENER_CLASS:
                listener.setListenerClass(text.toString());
                break;

            case LISTENER:
                webApp.addElementListeners(listener);
                break;

            case SERVLET_NAME:
                if (servlet != null) {
                    servlet.setServletName(text.toString());
                } else {
                    servletMapping.setServletName(text.toString());
                }
                break;

            case SERVLET_CLASS:
                servlet.setServletClass(text.toString());
                break;

            case SERVLET:
                webApp.addElementServlets(servlet);
                servlet = null;
                break;

            case SERVLET_MAPPING:
                webApp.addElementServletMappings(servletMapping);
                servletMapping = null;
                break;

            case EXCEPTION_TYPE:
                errorPage.setExceptionType(text.toString());
                break;

            case ERROR_CODE:
                errorPage.setErrorCode(text.toString());
                break;

            case LOCATION:
                errorPage.setLocation(text.toString());
                break;

            case ERROR_PAGE:
                webApp.addElementErrorPages(errorPage);
                errorPage = null;
                break;
        }
        return webApp;
    }
}
