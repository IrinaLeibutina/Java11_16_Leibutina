package com.company.bean;

import java.util.ArrayList;

public class WelcomeFileList {

    private ArrayList<String> welcomeFiles = new ArrayList<>();

    public void addElementWelcomeFile(String welcomeFile){
        welcomeFiles.add(welcomeFile);
    }

    @Override
    public String toString() {
        return "\nWelcomeFileList\n" +
                "welcomeFiles=" + welcomeFiles;
    }
}
