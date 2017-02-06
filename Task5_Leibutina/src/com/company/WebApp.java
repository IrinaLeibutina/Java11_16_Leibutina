package com.company;

import com.company.nodes.Listener;

public class WebApp {

    // TODO for all nodes
    private String displayName;
    protected Listener listener;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener value) {
        this.listener = value;
    }
}
