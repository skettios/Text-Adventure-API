package com.skettios.textadventure.api.command;

import com.skettios.textadventure.api.TextAdventureAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandRegistry
{
	private Map<String, ICommand> commandMap = new HashMap<String, ICommand>();
	private String invalidCommandMessage = "You can't do that.";

	public void registerCommand(String command, ICommand commandContainer)
	{
		commandMap.put(command, commandContainer);
	}

	public void executeCommand(String command, List<String> args)
	{
		if (!isCommandValid(command))
		{
			// TODO(skettios): Make it able to customize the "invalid command" message.
			TextAdventureAPI.sendMessage(invalidCommandMessage);
			return;
		}

		if (!canCommandExecute(command, args))
		{
			TextAdventureAPI.sendMessage(commandMap.get(command).getErrorMessage());
			return;
		}

		commandMap.get(command).onExecute(args);
	}

	public void setInvalidCommandMessage(String message)
	{
		invalidCommandMessage = message;
	}

	private boolean isCommandValid(String command)
	{
		return commandMap.containsKey(command);
	}

	private boolean canCommandExecute(String command, List<String> args)
	{
		return commandMap.get(command).canExecute(args);
	}
}
