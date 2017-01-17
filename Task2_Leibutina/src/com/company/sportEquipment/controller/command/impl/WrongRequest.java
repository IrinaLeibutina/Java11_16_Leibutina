package com.company.sportEquipment.controller.command.impl;

import com.company.sportEquipment.controller.command.Command;

public class WrongRequest implements Command {

    @Override
    public String execute(String request) {

        return "Wrong request";
    }
}