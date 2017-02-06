package com.company;

import com.company.nodes.Listener;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWebAppBuilder {
    // TODO for all nodes

    List<Listener> listener;

    public AbstractWebAppBuilder() {
        listener = new ArrayList<>();
    }

    public AbstractWebAppBuilder(List<Listener> listener) {
        this.listener = listener;
    }

    public List<Listener> getWebApp() {
        return listener;
    }

    abstract public void buildWebApp(String fileName);
}
