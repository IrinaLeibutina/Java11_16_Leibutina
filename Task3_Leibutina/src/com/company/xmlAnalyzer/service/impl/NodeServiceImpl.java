package com.company.xmlAnalyzer.service.impl;

import com.company.xmlAnalyzer.bean.Node;
import com.company.xmlAnalyzer.dao.FileHandlerDAO;
import com.company.xmlAnalyzer.dao.exception.DAOException;
import com.company.xmlAnalyzer.dao.factory.DAOFactory;
import com.company.xmlAnalyzer.service.NodeService;
import com.company.xmlAnalyzer.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class NodeServiceImpl implements NodeService {


    @Override
    public List<Node> getNode() throws ServiceException {

        Node currentNode = new Node();
        List<Node> allNodes = new ArrayList<>();
        AnalyzerServiceImpl analyzerService = new AnalyzerServiceImpl();
        String currentSubstring;

        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            FileHandlerDAO fileHandlerDAO = daoObjectFactory.getFileHandlerDAO();
            fileHandlerDAO.openFile();
            currentSubstring = fileHandlerDAO.readFile();

            currentNode = analyzerService.analysisLine(currentSubstring);

            while (currentNode.getType() != "end") {

                if (currentNode.getType() != null) {
                    allNodes.add(currentNode);
                }
                currentNode = analyzerService.analysisLine(currentSubstring);
            }
            fileHandlerDAO.closeFile();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return allNodes;
    }
}
