package com.company.xmlAnalyzer.view;

import com.company.xmlAnalyzer.bean.Node;
import com.company.xmlAnalyzer.service.NodeService;
import com.company.xmlAnalyzer.service.exception.ServiceException;
import com.company.xmlAnalyzer.service.factory.ServiceFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NodeService nodeService = serviceFactory.getNodeService();

        List<Node> allNodes = new ArrayList<>();

        try {
            allNodes = nodeService.getNode();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        // Print all nodes
        for (Node item : allNodes) {
            System.out.println("Node type - " + item.getType()
                    + "\nOpen tag - " + item.getOpenTag()
                    + "\nContent - " + item.getContent()
                    + "\nClose tag - " + item.getCloseTag());
        }

        // Print particular node
        Scanner in = new Scanner(System.in);
        int node = in.nextInt();

        if(node< allNodes.size()) {
            System.out.println("\nNode type - " + allNodes.get(node).getType()
                    + "\nOpen tag - " + allNodes.get(node).getOpenTag()
                    + "\nContent - " + allNodes.get(node).getContent()
                    + "\nClose tag - " + allNodes.get(node).getCloseTag());
        } else {
            System.out.println("Uncorrected data");
        }
    }
}
