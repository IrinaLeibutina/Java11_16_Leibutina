package com.company.sportEquipment.controller.command.impl;

import com.company.sportEquipment.bean.Equipment;
import com.company.sportEquipment.controller.command.Command;
import com.company.sportEquipment.service.ShopService;
import com.company.sportEquipment.service.exception.ServiceException;
import com.company.sportEquipment.service.factory.ServiceFactory;

public class AddEquipment implements Command {

    @Override
    public String execute(String request) {
        Equipment equipment = new Equipment();
        String title;
        String currentSubstring;
        int price;
        int amount;

        title = request.substring(request.indexOf("title"));
        title = title.substring(6, title.indexOf(' '));
        System.out.println("Title  - " + title);

        currentSubstring = request.substring(request.indexOf("price"));
        currentSubstring = currentSubstring.substring(6, currentSubstring.indexOf(' '));
        price = Integer.parseInt(currentSubstring);
        System.out.println("Price - " + price);

        currentSubstring = request.substring(request.indexOf("amount"));
        currentSubstring = currentSubstring.substring(7, currentSubstring.indexOf(' '));
        amount = Integer.parseInt(currentSubstring);
        System.out.println("Amount - " + amount);

        equipment.setTitle(title);
        equipment.setAmount(amount);
        equipment.setPrice(price);

        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ShopService shopService = serviceFactory.getShopService();
        try {
            shopService.addNewEquipment(equipment);
            response = "New good was add";
        } catch (ServiceException e) {
            response = "Error during add procedure";
        }

        return response;
    }
}