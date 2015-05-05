package com.skettios.textadventure.api;

import com.skettios.textadventure.api.command.CommandClear;
import com.skettios.textadventure.api.command.CommandExit;
import com.skettios.textadventure.api.command.CommandLoad;
import com.skettios.textadventure.api.command.CommandSave;

import java.util.ArrayList;
import java.util.List;

public abstract class TextAdventureContainer
{
	protected TextAdventureUI ui;

	public void start(String title)
	{
		ui = new TextAdventureUI(title);

		TextAdventureAPI.registerCommand("exit", new CommandExit(this));
		TextAdventureAPI.registerCommand("clear", new CommandClear(ui));
		TextAdventureAPI.registerCommand("save", new CommandSave(TextAdventureAPI.storyFlagManager));
		TextAdventureAPI.registerCommand("load", new CommandLoad(TextAdventureAPI.storyFlagManager));

		ui.start(this);
	}

	public synchronized void stop()
	{
		TextAdventureAPI.sendMessage("Thank you for playing!");

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
		} else
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
