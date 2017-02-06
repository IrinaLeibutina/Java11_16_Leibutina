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
    private Filter filter;
    private FilterMapping filterMapping;
    private Servlet servlet;
    private ServletMapping servletMapping;
    private ErrorPage errorPage;
    private WelcomeFileList welcomeFileList;

    private StringBuilder text;

    public List<Listener> getListenerList() {
        return listeners;
    }

    WebApp webApp = new WebApp();

    public void startDocument() throws SAXException {
        System.out.println("Parsing started.");
    }

    public void endDocument() throws SAXException {
        System.out.println("Parsing ended.");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("startElement -> " + "uri: " + uri + ", localName: " + localName

                + ", qName: " + qName); text = new StringBuilder();

        WebAppEnum tagName =
                WebAppEnum.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (tagName){
            case LISTENER:
                listener = new Listener();
                break;
            case WELCOME_FILE:
                welcomeFileList = new WelcomeFileList();
                break;
            case FILTER:
                filter = new Filter();
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
            case LISTENER_CLASS:
                listener.setListenerClass(text.toString());
                break;
           //case WELCOME_FILE:
           //      welcomeFileList.setWelcomeFiles(text.toString());
            //      break;
           // case FILTER_NAME:
           //     break;
           // case FILTER_CLASS:
           //     break;
           // case INIT_PARAM:
           //     break;
           // case PARAM_NAME:
           //     break;
           // case PARAM_VALUE:
           //     break;

           case LISTENER:

               webApp.setListener(listener);
               listeners.add(listener);
               listener = null;
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
