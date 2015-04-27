package com.skettios.textadventure.api;

import com.skettios.textadventure.api.command.CommandRegistry;

import java.util.ArrayList;
import java.util.List;

public abstract class TextAdventureContainer
{
	public void test()
	{
		parseCommand("test");
	}

	/**
	 * Method that is called on startup that should setup items and the character.
	 */
	public abstract void preInit();

	/**
	 * Method that is called on startup to setup rooms and other things.
	 */
	public abstract void init();

	/**
	 * Method that is called after inputting a command to console.
	 *
	 * @param commandLine
	 */
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

	/**
	 * Method to parse the incoming commands that will include arguments at each space.
	 * ie. Commands and arguments cannot have spaces. Use a '-' to simulate a space.
	 *
	 * @param command
	 * @param args
	 */
	public void parseCommand(String command, List<String> args)
	{
		TextAdventureAPI.commandRegistry.executeCommand(command, args);
	}
}
