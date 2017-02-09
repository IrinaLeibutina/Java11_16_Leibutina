package com.company.controller;


import com.company.service.AbstractWebAppBuilder;
import com.company.service.exception.ServiceException;
import com.company.service.factory.WebAppBuilderFactory;

public class Controller {

    public String parse(String parserType, final String fileName) {

        String response = null;

        WebAppBuilderFactory factory = new WebAppBuilderFactory();

        try {
            AbstractWebAppBuilder builder = factory.createWebAppBuilder(parserType);

            builder.buildWebApp(fileName);

            response = builder.getWebApp().toString();

        } catch (ServiceException e) {
            response = "Can not parse this file";
        }
        return response;
    }
}