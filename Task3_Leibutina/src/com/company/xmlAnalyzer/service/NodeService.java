package com.company.xmlAnalyzer.service;

import com.company.xmlAnalyzer.bean.Node;
import com.company.xmlAnalyzer.service.exception.ServiceException;

import java.util.List;

public interface NodeService {
    List<Node> getNode() throws ServiceException;
}
