package com.company.xmlAnalyzer.service.impl;

import com.company.xmlAnalyzer.bean.Node;
import com.company.xmlAnalyzer.dao.FileHandlerDAO;
import com.company.xmlAnalyzer.dao.exception.DAOException;
import com.company.xmlAnalyzer.dao.factory.DAOFactory;
import com.company.xmlAnalyzer.service.NodeService;
import com.company.xmlAnalyzer.service.exception.ServiceException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NodeServiceImpl implements NodeService {

    private String currentSubstring;

    @Override
    public List<Node> getNode() throws ServiceException {

        Node currentNode = new Node();
        List<Node> allNodes = new ArrayList<>();
        AnalyzerServiceImpl analyzerService = new AnalyzerServiceImpl();

        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            FileHandlerDAO fileHandlerDAO = daoObjectFactory.getFileHandlerDAO();
            currentSubstring = fileHandlerDAO.readFile();

            currentNode = analyzerService.analysisLine(currentSubstring);

            while (currentNode.getOpenTag() != "end" && currentNode.getCloseTag() != "end") {

                if (currentNode.getType() != null) {
                    allNodes.add(currentNode);
                }
                currentNode = analyzerService.analysisLine(currentSubstring);
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allNodes;
    }
}
