package com.company;

import java.util.*;

import com.company.nodes.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class WebAppHandler extends DefaultHandler {

    private List<Listener> listeners = new ArrayList<>();
    private List<Filter> filters = new ArrayList<>();
    private List<FilterMapping> filterMappings = new ArrayList<>();
    private List<Servlet> servlets = new ArrayList<>();
    private List<ServletMapping> servletMappings = new ArrayList<>();
    private List<ErrorPage> errorPages = new ArrayList<>();
    private List<WelcomeFileList> welcomeFileLists = new ArrayList<>();

    private Listener listener;
    private String displayName;
    private Filter filter;
    Filter.InitParam initParam;
    private FilterMapping filterMapping;
    private Servlet servlet;
    private ServletMapping servletMapping;
    private ErrorPage errorPage;
    private WelcomeFileList welcomeFileList;

    private StringBuilder text;
    WebApp webApp = new WebApp();


    public WebApp getWebApp() {
        return webApp;
    }


    public void startDocument() throws SAXException {
        System.out.println("Parsing started.");
    }

    public void endDocument() throws SAXException {
        System.out.println("Parsing ended.");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("startElement -> " + "uri: " + uri + ", localName: " + localName

                + ", qName: " + qName);
        text = new StringBuilder();

        WebAppEnum tagName =
                WebAppEnum.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (tagName) {

            //case DISPLAY_NAME:

            case LISTENER:
                listener = new Listener();
                break;
            case WELCOME_FILE:
                welcomeFileList = new WelcomeFileList();
                break;
            case FILTER:
                filter = new Filter();
                initParam = new Filter.InitParam();
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
            case WEB_APP:
                // add atr
                break;
        }
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        WebAppEnum tagName =
                WebAppEnum.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (tagName) {

            case LISTENER:
                listener.setListenerClass(text.toString());
                webApp.addElementListeners(listener);
                //webApp.setListener(listener);
                //  listeners.add(listener);
                listener = null;
                break;

            case DISPLAY_NAME:
                displayName = text.toString();
                webApp.setDisplayName(displayName);
                break;
            // case LISTENER_CLASS:
            //     listener.setListenerClass(text.toString());
            //     break;
            //case WELCOME_FILE:
            //      welcomeFileList.setWelcomeFiles(text.toString());
            //      break;
            case FILTER_NAME:
//                     filterMapping.setFilterName(text.toString());
                //             webApp.addElementFilterMappings(filterMapping);
                break;
            // case FILTER_CLASS:
            //     break;
            // case INIT_PARAM:
            //     break;
            // case PARAM_NAME:
            //     break;
            // case PARAM_VALUE:
            //     break;
            // case SERVLET_NAME:
            //servlet.setServletName("1");
            //   servlet.setServletName(text.toString());
            //   System.out.println("364" + text.toString());
            //   webApp.addElementServlets(servlet);

            //    servlet = null;
            //    break;

            case SERVLET_CLASS:
                servlet.setServletClass(text.toString());
                System.out.println("364" + text.toString());
                webApp.addElementServlets(servlet);

                servlet = null;
                break;

           //case URL_PATTERN:
           //    System.out.println("56888" + tagName);
           //    servletMapping.setUrlPattern(text.toString());
           //    webApp.addElementServletMappings(servletMapping);
           //    break;

            case FILTER_CLASS:
                filter.setFilterClass(text.toString());
                webApp.addElementFilters(filter);
                //filter = null; // Check
                break;

          // case INIT_PARAM:
          //
          //     initParam.setParamName(text.toString());
          //     filter.setInitParam(initParam);
          //     webApp.addElementFilters(filter);
          //
          //     break;
            case PARAM_NAME:
                break;

            case PARAM_VALUE:
                break;

            case DISPATCHER:
                filterMapping.setDispatcher(text.toString());
                webApp.addElementFilterMappings(filterMapping);
                filterMapping = null; // Check
                break;

            case EXCEPTION_TYPE:
                errorPage.setExceptionType(text.toString());
                webApp.addElementErrorPages(errorPage);
                break;

            case ERROR_CODE:
                errorPage.setErrorCode(text.toString());
                webApp.addElementErrorPages(errorPage);
                break;

            case LOCATION:
                errorPage.setLocation(text.toString());
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
