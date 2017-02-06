package com.company.sportEquipment.controller.command.impl;

import com.company.sportEquipment.controller.command.Command;
import com.company.sportEquipment.service.ClientService;
import com.company.sportEquipment.service.exception.ServiceException;
import com.company.sportEquipment.service.factory.ServiceFactory;

public class SingIn implements Command {

    @Override
    public String execute(String request) {
        String login = null;
        String password = null;

        String response = null;

        login = request.substring(request.indexOf("login"));
        login = login.substring(6, login.indexOf(" "));

        password = request.substring(request.indexOf("password"));
        password = password.substring(9);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        try {
            clientService.singIn(login, password);
            response = "Welcome " + clientService.singIn(login, password);
            response = "Welcome " + clientService.singIn(login, password);
        } catch (ServiceException e) {
            response = "Error during login procedure";
        }

        return response;
    }
}