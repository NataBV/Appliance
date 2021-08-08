package by.tc.task01.controller;

import by.tc.task01.controller.Command;
import by.tc.task01.controller.CommandProvider;
import by.tc.task01.controller.validator.Validator;

public class FrontController {
	private static final int COMMAND_NAME = 0;
	
	private final CommandProvider provider = new CommandProvider();
	
	public String doAction(String request) {
		
		if (!Validator.requestValidator(request)) { //TODO body
			return null;
		}

		String[] params = request.split("\\s+",2);
		String commandName = params[COMMAND_NAME];
		
		String response;
		Command command;
		
		command = provider.takeCommand(commandName);
		response = command.execute(request);
		
		return response;
	}
	
	

}
