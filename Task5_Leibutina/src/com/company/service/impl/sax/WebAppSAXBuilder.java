package com.company.service.impl.sax;

import java.io.IOException;

import com.company.service.AbstractWebAppBuilder;
import com.company.bean.WebApp;
import com.company.service.exception.ServiceException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class WebAppSAXBuilder extends AbstractWebAppBuilder {

    private WebAppSAX webAppSAX;
    private XMLReader reader;

    private WebApp webApp;

    public WebAppSAXBuilder() throws ServiceException {

        webApp = new WebApp();
        webAppSAX = new WebAppSAX();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(webAppSAX);
        } catch (SAXException e) {
            throw new ServiceException("Error SAX parser");
        }
    }

    @Override
    public void buildWebApp(String fileName) throws ServiceException {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            throw new ServiceException("Error SAX parser: ");
        } catch (IOException e) {
            throw new ServiceException("Error I/O stream");
        }
        webApp = webAppSAX.getWebApp();
    }

   public WebApp getWebApp() {
       return webApp;
   }
}





