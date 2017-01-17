package com.company.sportEquipment.controller;

import com.company.sportEquipment.controller.command.Command;
import com.company.sportEquipment.controller.command.CommandName;
import com.company.sportEquipment.controller.command.impl.*;
import com.company.sportEquipment.controller.command.impl.SingIn;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {

    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SingIn());
        repository.put(CommandName.REGISTRATION, new Register());
        repository.put(CommandName.ADD_EQUIPMENT, new AddEquipment());
        repository.put(CommandName.RENT_EQUIPMENT, new RentEquipment());
        repository.put(CommandName.RETURN_EQUIPMENT, new ReturnEquipment());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }
}