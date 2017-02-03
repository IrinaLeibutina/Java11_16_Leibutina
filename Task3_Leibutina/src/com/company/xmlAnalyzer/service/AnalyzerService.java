package com.company.xmlAnalyzer.service;

import com.company.xmlAnalyzer.bean.Node;
import com.company.xmlAnalyzer.service.exception.ServiceException;

import java.io.IOException;

public interface AnalyzerService {
   Node analysisLine(String text) throws ServiceException,IOException;
}
