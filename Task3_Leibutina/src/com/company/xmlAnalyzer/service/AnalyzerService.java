package com.company.xmlAnalyzer.service;

import com.company.xmlAnalyzer.bean.Node;
import com.company.xmlAnalyzer.service.exception.ServiceException;

public interface AnalyzerService {
   Node analysisLine(String text) throws ServiceException;
}
