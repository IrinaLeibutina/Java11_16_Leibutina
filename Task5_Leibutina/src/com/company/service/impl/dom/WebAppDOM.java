package com.company.service.impl.dom;

import com.company.bean.WebApp;
import com.company.bean.*;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class WebAppDOM {

    DOMParser parser;
    private WebApp webApp;

    public WebAppDOM(DOMParser parser) {
        this.parser = parser;
    }

    public WebApp parse() {
        webApp = new WebApp();

        Document document = parser.getDocument();
        Element root = document.getDocumentElement();

        webApp.setVersion(root.getAttribute("version"));
        webApp.setId(root.getAttribute("id"));
        webApp.setDisplayName(getDisplayName(root));
        webApp.addElementWelcomeFileLists(getWelcomeFileList(root));
        webApp.addElementFilters(getFilter(root));
        webApp.addElementFilterMappings(getFilterMapping(root));
        webApp.addElementListeners(getListener(root));
        webApp.addElementServlets(getServlet(root));
        webApp.addElementServletMappings(getServletMapping(root));
        webApp.addElementErrorPages(getErrorPages(root));

        return webApp;
    }

    private String getDisplayName(Element root) {
        NodeList displayNameNodes = root.getElementsByTagName("display-name");
        String displayName = null;
        for (int i = 0; i < displayNameNodes.getLength(); i++) {
            Element displayNameElement = (Element) displayNameNodes.item(i);
            displayName = displayNameElement.getTextContent().trim();
        }
        return displayName;
    }

    private WelcomeFileList getWelcomeFileList(Element root) {
        NodeList welcomeFileListNodes = root.getElementsByTagName("welcome-file-list");
        WelcomeFileList welcomeFileList = null;
        for (int i = 0; i < welcomeFileListNodes.getLength(); i++) {
            welcomeFileList = new WelcomeFileList();
            Element welcomeFileListElement = (Element) welcomeFileListNodes.item(i);
            NodeList welcomeFileNodes = welcomeFileListElement.getElementsByTagName("welcome-file");
            for (int j = 0; j < welcomeFileNodes.getLength(); j++) {
                Element welcomeFileElement = (Element) welcomeFileNodes.item(j);
                welcomeFileList.addElementWelcomeFile(welcomeFileElement.getTextContent().trim());
            }
        }
        return welcomeFileList;
    }

    private Filter getFilter(Element root) {
        NodeList filterNodes = root.getElementsByTagName("filter");
        Filter filter = null;
        for (int i = 0; i < filterNodes.getLength(); i++) {
            filter = new Filter();
            Element filterElement = (Element) filterNodes.item(i);
            filter.setFilterName(getSingleChildElement(filterElement, "filter-name").getTextContent().trim());
            filter.setFilterClass(getSingleChildElement(filterElement, "filter-class").getTextContent().trim());
             filter.setInitParam(getInitParam(filterElement));
        }
        return filter;
    }

    private FilterMapping getFilterMapping(Element root) {
        FilterMapping filterMapping = null;
        NodeList filterMappingNodes = root.getElementsByTagName("filter-mapping");
        for (int i = 0; i < filterMappingNodes.getLength(); i++) {
            filterMapping = new FilterMapping();
            Element filterMappingElement = (Element) filterMappingNodes.item(i);
            filterMapping.setFilterName(getSingleChildElement(filterMappingElement, "filter-name").getTextContent().trim());
            filterMapping.setUrlPattern(getSingleChildElement(filterMappingElement, "url-pattern").getTextContent().trim());
            filterMapping.setDispatcher(getSingleChildElement(filterMappingElement, "dispatcher").getTextContent().trim());
        }
        return filterMapping;
    }

    private Listener getListener(Element root) {
        Listener listener = null;
        NodeList listenerNodes = root.getElementsByTagName("listener");
        for (int i = 0; i < listenerNodes.getLength(); i++) {
            listener = new Listener();
            Element listenerElement = (Element) listenerNodes.item(i);
            listener.setListenerClass(getSingleChildElement(listenerElement, "listener-class").getTextContent().trim());
        }
        return listener;
    }

    private Servlet getServlet(Element root) {
        Servlet servlet = null;
        NodeList servletNodes = root.getElementsByTagName("servlet");
        for (int i = 0; i < servletNodes.getLength(); i++) {
            servlet = new Servlet();
            Element servletElement = (Element) servletNodes.item(i);
            servlet.setServletName(getSingleChildElement(servletElement, "servlet-name").getTextContent().trim());
            servlet.setServletClass(getSingleChildElement(servletElement, "servlet-class").getTextContent().trim());
              servlet.setInitParam(getInitParam(servletElement));

        }
        return servlet;
    }

    private ServletMapping getServletMapping(Element root) {
        ServletMapping servletMapping = null;
        NodeList servletMappingNodes = root.getElementsByTagName("servlet-mapping");
        for (int i = 0; i < servletMappingNodes.getLength(); i++) {
            servletMapping = new ServletMapping();
            Element servletMappingElement = (Element) servletMappingNodes.item(i);
            servletMapping.setServletName(getSingleChildElement(servletMappingElement, "servlet-name").getTextContent().trim());
            servletMapping.setUrlPattern(getSingleChildElement(servletMappingElement, "url-pattern").getTextContent().trim());
        }
        return servletMapping;
    }

    private ErrorPage getErrorPages(Element root) {
        ErrorPage errorPage = null;
        NodeList errorPageNodes = root.getElementsByTagName("error-page");
        for (int i = 0; i < errorPageNodes.getLength(); i++) {
            errorPage = new ErrorPage();
            Element errorPageElement = (Element) errorPageNodes.item(i);
            try {
                errorPage.setExceptionType(getSingleChildElement(errorPageElement, "exception-type").getTextContent().trim());
            } catch (NullPointerException e) {
            }
            try {
                errorPage.setErrorCode(getSingleChildElement(errorPageElement, "error-code").getTextContent().trim());
            } catch (NullPointerException e) {
            }
            errorPage.setLocation(getSingleChildElement(errorPageElement, "location").getTextContent().trim());
        }
        return errorPage;
    }
   private InitParam getInitParam (Element root) {
        InitParam initParam = new InitParam();
        Element initParamsElement = getSingleChildElement(root,"init-param");
        if (initParamsElement != null ) {
            initParam.setParamName(getSingleChildElement(initParamsElement, "param-name").getTextContent().trim());
            initParam.setParamValue(getSingleChildElement(initParamsElement, "param-value").getTextContent().trim());
        }
        if ((initParam.getParamName()==null)||(initParam.getParamValue()==null)) {
            initParam = null;
        }
        return initParam;
    }

    private Element getSingleChildElement(Element root, String childName) {
        NodeList nodeList = root.getElementsByTagName(childName);
        return nodeList.getLength() > 0 ? (Element) nodeList.item(0) : null;
    }
}



