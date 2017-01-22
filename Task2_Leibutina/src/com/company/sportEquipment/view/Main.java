package com.company.sportEquipment.view;

import com.company.sportEquipment.controller.Controller;

public class Main {

    public static void main(String[] args) {
        String result;
        String client;

        Controller controller = new Controller();

        client = controller.executeTask("REGISTRATION name=NAME surname=SURNAME" +
                " login=LOGIN password=PASSWORD");
        System.out.println("Registration\n" + client);

        client = controller.executeTask("SIGN_IN login=LOGIN password=PASSWORD ");
        System.out.println("Sign in\n" + client);

        result = controller.executeTask("ADD_EQUIPMENT title=Skiing amount=20" +
                " price=75 ");
        System.out.println("Add equipment\n" + result);

        result = controller.executeTask("RENT_EQUIPMENT title=Skiing amount=9 " + client);
        System.out.println("Rent equipment\n" + result);

        result = controller.executeTask("RETURN_EQUIPMENT title=Skiing " + client);
        System.out.println("Return equipment\n" + result);
    }
}
