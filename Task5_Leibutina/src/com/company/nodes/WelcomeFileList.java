package com.company.nodes;

import java.util.ArrayList;

public class WelcomeFileList {

    private ArrayList<String> welcomeFiles = new ArrayList<>();

    public ArrayList<String> getWelcomeFiles() {
        return welcomeFiles;
    }

    public void setWelcomeFiles(ArrayList<String> welcomeFiles) {
        this.welcomeFiles = welcomeFiles;
    }

    public void addWelcomeFile(String welcomeFile){
        welcomeFiles.add(welcomeFile);
    }
}
