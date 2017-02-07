package com.company;

import java.io.IOException;
import java.util.List;

import com.company.nodes.Listener;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class WebAppSAXBuilder extends AbstractWebAppBuilder {

    private WebAppHandler sh;
    private XMLReader reader;

    private WebApp webApp;

    public WebAppSAXBuilder() {

        webApp = new WebApp();
        sh = new WebAppHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();

            reader.setContentHandler(sh);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }

    @Override
    public void buildWebApp(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        webApp = sh.getWebApp();

        System.out.println(webApp.getListeners());
       // System.out.println("DisplayName =  " + webApp.getDisplayName());
        System.out.println(webApp.getFilterMappings());

       // System.out.println("Servlet" + webApp.getServlets());
        System.out.println("ServletMapping" + webApp.getServletMappings());

        System.out.println(webApp.getErrorPages());
    }

   //public List<Listener> getWebApp() {
   //    return webApp.getListeners();
   //}
}





