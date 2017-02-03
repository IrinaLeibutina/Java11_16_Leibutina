package com.company.xmlAnalyzer.service.impl;

import com.company.xmlAnalyzer.bean.Node;;
import com.company.xmlAnalyzer.service.AnalyzerService;
import com.company.xmlAnalyzer.service.exception.ServiceException;

public class AnalyzerServiceImpl implements AnalyzerService {

    private int posBegin = 0;
    private int posEnd = 0;
    private final String OPEN_TAG = "<";
    private final String CLOSE_TAG = ">";

    @Override
    public Node analysisLine(String text) throws ServiceException {

        if (text == null || text.isEmpty()) {
            throw new ServiceException("Incorrect input data");
        }

        String findCloseTag = "";
        String tag;

        Node node = new Node();

        if (posEnd >= text.length()) {
            node.setType("end");
            return node;
        }

        posBegin = text.indexOf(OPEN_TAG, posBegin);
        posEnd = text.indexOf(CLOSE_TAG, posEnd);

        tag = text.substring(posBegin, posEnd + 1);

        if (tag.contains("xml")) {
            posBegin = posBegin + 1;
            posEnd = posEnd + 1;

            return node;
        }

        if (tag.contains(" ")) {
            int findSpace = tag.indexOf(" ");
            int begin = tag.indexOf(OPEN_TAG);
            findCloseTag = OPEN_TAG + "/" + tag.substring(begin + 1, findSpace) + CLOSE_TAG;

            int findPos = text.indexOf(findCloseTag, posEnd);
            String content = text.substring(posEnd + 1, findPos);

            node.setType("Attribute node");
            node.setOpenTag(tag);
            node.setContent(content);
            node.setCloseTag(findCloseTag);
        } else {
            if (!tag.contains("/")) {
                findCloseTag = OPEN_TAG + "/" + text.substring(posBegin + 1, posEnd) + CLOSE_TAG;
                int findPos = text.indexOf(findCloseTag, posEnd);

                String content = text.substring(posEnd + 1, findPos);

                if (!content.contains("<")) {
                    node.setType("Text node");
                } else {
                    node.setType("Root node");
                }

                node.setOpenTag(text.substring(posBegin, posEnd + 1));
                node.setContent(content);
                node.setCloseTag(findCloseTag);
            }
        }

        posBegin = posBegin + 1;
        posEnd = posEnd + 1;

        return node;
    }
}
