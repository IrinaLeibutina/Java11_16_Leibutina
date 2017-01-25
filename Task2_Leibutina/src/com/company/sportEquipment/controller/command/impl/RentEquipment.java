package com.company.sportEquipment.controller.command.impl;

import com.company.sportEquipment.controller.command.Command;
import com.company.sportEquipment.service.ShopService;
import com.company.sportEquipment.service.exception.ServiceException;
import com.company.sportEquipment.service.factory.ServiceFactory;

public class RentEquipment implements Command {

    @Override
    public String execute(String request) {

        String response = null;

        request = request.substring(request.indexOf("title"));// именуем константные строки
        System.out.println(request);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ShopService shopService = serviceFactory.getShopService();
        try {
            shopService.rentEquipment(request);
            response = "Equipment can be rented";
        } catch (ServiceException e) {
            response = "There are no equipment";// не уверена, что это подходящее сообщение в случае появления исключения)
        }

        return response;
    }
}
