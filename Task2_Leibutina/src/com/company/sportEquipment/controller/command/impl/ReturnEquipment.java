package com.company.sportEquipment.controller.command.impl;

import com.company.sportEquipment.controller.command.Command;
import com.company.sportEquipment.service.ShopService;
import com.company.sportEquipment.service.exception.ServiceException;
import com.company.sportEquipment.service.factory.ServiceFactory;

public class ReturnEquipment implements Command {
    @Override
    public String execute(String request) {
        String response = null;

        request = request.substring(request.indexOf("title"));
        System.out.println(request);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ShopService shopService = serviceFactory.getShopService();
        try {
            shopService.returnEquipment(request);
            response = "Equipment was returned";
        } catch (ServiceException e) {
            response = "Equipment wasn't returned";
        }

        return response;
    }
}
