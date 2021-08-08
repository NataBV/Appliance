package by.tc.task01.controller;

import java.util.HashMap;
import java.util.Map;

import by.tc.task01.controller.impl.AddApplianceCommand;
import by.tc.task01.controller.impl.FindApplianceCommand;
import by.tc.task01.controller.impl.RemoveApplianceCommand;

public class CommandProvider {

	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.FIND, new FindApplianceCommand());
		commands.put(CommandName.ADD, new AddApplianceCommand());
		commands.put(CommandName.REMOVE, new RemoveApplianceCommand());
	}
	
	public Command takeCommand(String commandName) {
		CommandName name = CommandName.valueOf(commandName.toUpperCase());
		Command command = commands.get(name);
		
		return command;
	}	

	
}
