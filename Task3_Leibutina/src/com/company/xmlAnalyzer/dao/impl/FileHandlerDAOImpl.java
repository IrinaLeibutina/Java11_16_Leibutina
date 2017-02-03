package com.company.xmlAnalyzer.dao.impl;

import com.company.xmlAnalyzer.dao.FileHandlerDAO;
import com.company.xmlAnalyzer.dao.exception.DAOException;

import java.io.RandomAccessFile;

public class FileHandlerDAOImpl implements FileHandlerDAO {

    private final String PATH = "src/Example.xml";
    private RandomAccessFile file;

    @Override
    public void openFile() throws DAOException {
        try {
            file = new RandomAccessFile(PATH, "r");
        } catch (Exception IOException) {
            throw new DAOException();
        }
    }

    @Override
    public void closeFile() throws DAOException {
        try {
            file.close();
        } catch (Exception IOException) {
            throw new DAOException();
        }
    }

    @Override
    public String readFile() throws DAOException {

        try {
            String text = "";
            int b = file.read();

            while (b != -1) {
                text = text + (char) b;
                b = file.read();
            }

            return text;
        } catch (Exception IOException) {
            throw new DAOException();
        }
    }

    @Override
    public String readPartFile(int from, int to) throws DAOException {

        try {
             String text = "";

             file.seek(from);
             int b = file.read();

             while (b != -1 && to > 0) {
                 text = text + (char) b;
                 --to;
                b = file.read();
            }

            return text;
        }
        catch (Exception IOException){
            throw new DAOException();
        }
    }

}
