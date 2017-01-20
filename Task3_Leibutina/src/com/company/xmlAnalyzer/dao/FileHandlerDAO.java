package com.company.xmlAnalyzer.dao;


import com.company.xmlAnalyzer.dao.exception.DAOException;

import java.io.IOException;

public interface FileHandlerDAO {
    String readFile() throws DAOException, IOException;
    String readPartFile(int from, int to) throws DAOException, IOException;
}
