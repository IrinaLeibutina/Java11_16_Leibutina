package com.company.service.impl.sax;

import com.company.bean.WebApp;
import com.company.bean.WebAppEnum;
import com.company.bean.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class WebAppSAX extends DefaultHandler {

    private Listener listener;
    private Filter filter;
    InitParam initParam;
    private FilterMapping filterMapping;
    private Servlet servlet;
    private ServletMapping servletMapping;
    private ErrorPage errorPage;
    private WelcomeFileList welcomeFileList;

    private StringBuilder text;
    WebApp webApp;

    public WebApp getWebApp() {
        return webApp;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        text = new StringBuilder();

        WebAppEnum tagName =
                WebAppEnum.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (tagName) {

            case WEB_APP:
                webApp = new WebApp();
                webApp.setId(attributes.getValue("id"));
                webApp.setVersion(attributes.getValue("version"));
                break;
            case LISTENER:
                listener = new Listener();
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
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        WebAppEnum tagName = WebAppEnum.valueOf(qName.toUpperCase().replace("-", "_"));

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
    }

    public void warning(SAXParseException exception) {
        System.err.println("WARNING: line " + exception.getLineNumber() + ": "
                + exception.getMessage());
    }

    public void error(SAXParseException exception) {
        System.err.println("ERROR: line " + exception.getLineNumber() + ": "
                + exception.getMessage());
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("FATAL: line " + exception.getLineNumber() + ": "
                + exception.getMessage());
        throw (exception);
    }
}
