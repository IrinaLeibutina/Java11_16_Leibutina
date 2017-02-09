package com.company.bean;

public class Listener {
    private String listenerClass;

    public void setListenerClass(String listenerClass) {
        this.listenerClass = listenerClass;
    }

    @Override
    public String toString() {
        return "\n\tListener" +
                "\nlistenerClass='" + listenerClass + '\'';
    }
}
