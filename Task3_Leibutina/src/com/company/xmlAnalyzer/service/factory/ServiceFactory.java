package com.company.xmlAnalyzer.service.factory;

import com.company.xmlAnalyzer.service.AnalyzerService;
import com.company.xmlAnalyzer.service.NodeService;
import com.company.xmlAnalyzer.service.impl.AnalyzerServiceImpl;
import com.company.xmlAnalyzer.service.impl.NodeServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final AnalyzerService analyzerService = new AnalyzerServiceImpl();
    private final NodeService nodeService = new NodeServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public AnalyzerService getAnalyzerService() {
        return analyzerService;
    }

    public NodeService getNodeService() {
        return nodeService;
    }

}
