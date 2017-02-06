package com.company.nodes;

public class Listener {
    private String listenerClass;

    public String getListenerClass() {
        return listenerClass;
    }

    public void setListenerClass(String listenerClass) {
        this.listenerClass = listenerClass;
    }

    @Override
    public String toString() {
        return "\n\tListener{" +
                "\nlistenerClass='" + listenerClass + '\'' +
                '}';
    }
}
