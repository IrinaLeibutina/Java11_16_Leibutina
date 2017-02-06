package com.company;

import com.company.nodes.FilterMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WebAppDOMBuilder extends AbstractWebAppBuilder {

    // for 1 node
    private Set<FilterMapping> filterMappings;
    private DocumentBuilder docBuilder;

    public WebAppDOMBuilder() {
        this.filterMappings = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public Set<FilterMapping> getFilters() {
        return filterMappings;
    }

    @Override
    public void buildWebApp(String fileName) {
        Document doc = null;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();

            NodeList filterMappingList = root.getElementsByTagName("filter-mapping");
            for (int i = 0; i < filterMappingList.getLength(); i++) {
                Element filterMappingElement = (Element) filterMappingList.item(i);
                FilterMapping filterMapping = buildSetFilter2(filterMappingElement);

                filterMappings.add(filterMapping);
            }
        } catch (IOException e) {
            System.err.println(e);
        } catch (SAXException e) {
            System.err.println(e);
        }
    }

    private FilterMapping buildSetFilter2(Element filterMappingElement) {
        FilterMapping filterMapping = new FilterMapping();

        filterMapping.setFilterName(getElementTextContent(filterMappingElement, "filter-name"));
        filterMapping.setUrlPattern(getElementTextContent(filterMappingElement, "url-pattern"));
        filterMapping.setDispatcher(getElementTextContent(filterMappingElement, "dispatcher"));

        return filterMapping;
    }

    private static String getElementTextContent(Element element, String elementName) {
        try {
            NodeList nList = element.getElementsByTagName(elementName);
            Node node = nList.item(0);
            String text = node.getTextContent();
            return text;
        } catch (Exception e) {
            return null;
        }
    }

}


