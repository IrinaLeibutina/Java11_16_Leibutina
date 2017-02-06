package com.company;

public class Main {

    public static void main(String[] args) {
        WebAppBuilderFactory sFactory = new WebAppBuilderFactory();
        AbstractWebAppBuilder builder = sFactory.createWebAppBuilder("sax");
        builder.buildWebApp("src/resources/web.xml");
        System.out.println(builder.getWebApp());

    }
}
