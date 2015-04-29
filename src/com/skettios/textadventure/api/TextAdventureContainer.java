package com.skettios.textadventure.api;

import java.util.ArrayList;
import java.util.List;

public abstract class TextAdventureContainer
{
	protected TextAdventureUI ui = new TextAdventureUI();

	public void start()
	{
		ui.start(this);
	}

	public void stop()
	{
		for (int i = 1; i <= 10; i++)
			TextAdventureAPI.sendMessage("Exiting game in " + i + "...");

		System.exit(0);
	}

	public abstract void initialize();

	protected void parseCommand(String commandLine)
	{
		List<String> args = new ArrayList<String>();
		String command;
		String argsLine = "";

		if (commandLine.contains(" "))
		{
			command = commandLine.substring(0, commandLine.indexOf(' '));
			argsLine = commandLine.substring(command.length() + 1, commandLine.length());

			while (argsLine.contains(" "))
			{
				String arg = argsLine.substring(0, argsLine.indexOf(" "));
				argsLine = argsLine.substring(arg.length() + 1, argsLine.length());

				args.add(arg);
			}
			args.add(argsLine);
		}
		else
		{
			command = commandLine;
		}

		parseCommand(command, args);
	}

	private void parseCommand(String command, List<String> args)
	{
		TextAdventureAPI.commandRegistry.executeCommand(command, args);
	}
}
