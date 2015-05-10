package com.skettios.textadventure.api;

import com.skettios.textadventure.api.command.CommandClear;
import com.skettios.textadventure.api.command.CommandExit;
import com.skettios.textadventure.api.command.CommandLoad;
import com.skettios.textadventure.api.command.CommandSave;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class TextAdventureContainer
{
	protected TextAdventureUI ui;
	private String title;
	protected File saveDir;

	public TextAdventureContainer(String title, String saveDir)
	{
		this.title = title;
		this.saveDir = new File(saveDir);

		if (!this.saveDir.exists())
			this.saveDir.mkdir();
	}

	public void start()
	{
		ui = new TextAdventureUI(title);

		TextAdventureAPI.registerCommand(new CommandExit(this));
		TextAdventureAPI.registerCommand(new CommandClear(ui));
		TextAdventureAPI.registerCommand(new CommandSave(TextAdventureAPI.storyFlagManager));
		TextAdventureAPI.registerCommand(new CommandLoad(TextAdventureAPI.storyFlagManager));

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
		commandLine = commandLine.toLowerCase();

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
