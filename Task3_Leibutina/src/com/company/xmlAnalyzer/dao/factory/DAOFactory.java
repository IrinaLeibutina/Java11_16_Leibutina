package com.company.xmlAnalyzer.dao.factory;


import com.company.xmlAnalyzer.dao.FileHandlerDAO;
import com.company.xmlAnalyzer.dao.exception.DAOException;
import com.company.xmlAnalyzer.dao.impl.FileHandlerDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final FileHandlerDAO fileHandler = new FileHandlerDAOImpl() ;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public FileHandlerDAO getFileHandlerDAO(){
        return fileHandler;
    }

}
