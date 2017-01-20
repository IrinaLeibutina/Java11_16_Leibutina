package com.company.xmlAnalyzer.bean;

public class Node {
    private String type;
    private String openTag;
    private String closeTag;
    private String content;

    public Node(){}

    public String getOpenTag() {
        return openTag;
    }

    public void setOpenTag(String openTag) {
        this.openTag = openTag;
    }

    public String getCloseTag() {
        return closeTag;
    }

    public void setCloseTag(String closeTag) {
        this.closeTag = closeTag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
