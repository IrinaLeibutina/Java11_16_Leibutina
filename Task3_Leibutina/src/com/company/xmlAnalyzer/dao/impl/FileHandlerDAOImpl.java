package com.company.xmlAnalyzer.dao.impl;

import com.company.xmlAnalyzer.dao.FileHandlerDAO;
import com.company.xmlAnalyzer.dao.exception.DAOException;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileHandlerDAOImpl implements FileHandlerDAO {

    private String path = "Example.xml";
    private RandomAccessFile file;

    @Override
    public String readFile() throws DAOException, IOException {

        file = new RandomAccessFile(path, "r");
        String text = "";
        int b = file.read();

        while (b != -1) {
            text = text + (char) b;
            b = file.read();
        }
        file.close();

        return text;
    }

    @Override
    public String readPartFile(int from, int to) throws DAOException, IOException {
        file = new RandomAccessFile(path, "r");
        String text = "";

        file.seek(from);
        int b = file.read();

        while (b != -1 && to > 0) {
            text = text + (char) b;
            --to;
            b = file.read();
        }
        file.close();

        return text;
    }

}
