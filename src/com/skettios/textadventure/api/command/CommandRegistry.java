package com.skettios.textadventure.api.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandRegistry
{
	private Map<String, ICommand> commandMap = new HashMap<String, ICommand>();

	public void registerCommand(String command, ICommand commandContainer)
	{
		commandMap.put(command, commandContainer);
	}

	public void executeCommand(String command, List<String> args)
	{
		if (!isCommandValid(command))
		{
			// TODO(skettios): Make it able to customize the "invalid command" message.
			System.out.println("You can't do that.");
			return;
		}

		if (!canCommandExecute(command, args))
		{
			System.out.println(commandMap.get(command).getErrorMessage());
			return;
		}

		commandMap.get(command).onExecute(args);
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
