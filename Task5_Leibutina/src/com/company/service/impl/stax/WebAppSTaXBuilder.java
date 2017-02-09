package com.company.service.impl.stax;

import com.company.service.AbstractWebAppBuilder;
import com.company.bean.WebApp;
import com.company.service.exception.ServiceException;
;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class WebAppSTaXBuilder  extends AbstractWebAppBuilder {
    private WebApp webApp;

    public WebAppSTaXBuilder(){
         webApp= new WebApp();
    }
    public void buildWebApp(String path) throws ServiceException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            InputStream input = new FileInputStream(path);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            WebAppStAX webAppStAX = new WebAppStAX();
            webApp = webAppStAX.process(reader);
        } catch (FileNotFoundException e) {
            throw new ServiceException();
        } catch (XMLStreamException e) {
            throw new ServiceException(e.getMessage(),e.getCause());
        }
    }

    public WebApp getWebApp() {
        return webApp;
    }
}
