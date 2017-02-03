package com.company.xmlAnalyzer.dao;


import com.company.xmlAnalyzer.dao.exception.DAOException;

import java.io.IOException;

public interface FileHandlerDAO {
    void openFile() throws DAOException;
    void closeFile() throws DAOException;
    String readFile() throws DAOException;
    String readPartFile(int from, int to) throws DAOException;
}
