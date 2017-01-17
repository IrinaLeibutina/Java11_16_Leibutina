package com.company.sportEquipment.controller;

import com.company.sportEquipment.controller.command.Command;


public final class Controller {
    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request) {

        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(' '));
        executionCommand = provider.getCommand(commandName);

        String response;
        response = executionCommand.execute(request);

        return response;
    }
}