package com.skettios.textadventure.api;

import com.skettios.textadventure.api.command.CommandRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class TextAdventureContainer
{
	private boolean isRunning = false;

	public void start()
	{
		isRunning = true;

		Scanner in = new Scanner(System.in);

		while (isRunning)
		{
			System.out.print("> ");
			String commandLine = in.nextLine();
			parseCommand(commandLine);
		}
	}

	public void stop()
	{
		isRunning = false;
	}

	public abstract void initialize();

	private void parseCommand(String commandLine)
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
