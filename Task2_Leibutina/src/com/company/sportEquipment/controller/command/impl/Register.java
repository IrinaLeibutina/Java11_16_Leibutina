package com.company.sportEquipment.controller.command.impl;


import com.company.sportEquipment.bean.User;
import com.company.sportEquipment.controller.command.Command;
import com.company.sportEquipment.service.ClientService;
import com.company.sportEquipment.service.exception.ServiceException;
import com.company.sportEquipment.service.factory.ServiceFactory;

public class Register implements Command {

    @Override
    public String execute(String request) {

        User user = new User();
        String name = null;
        String surname = null;
        String login = null;
        String password = null;

        name = request.substring(request.indexOf("name"));
        name = name.substring(5, name.indexOf(' '));

        surname = request.substring(request.indexOf("surname"));
        surname = surname.substring(8, surname.indexOf(' '));

        login = request.substring(request.indexOf("login"));
        login = login.substring(6, login.indexOf(' '));

        password = request.substring(request.indexOf("password"));
        password = password.substring(9);

        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setPassword(password);

        String response= null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        try {
            clientService.registration(user);
            response = "Welcome";
        } catch (ServiceException e) {
            response = "Error during register procedure";
        }

        return response;
    }
}