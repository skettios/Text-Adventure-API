package com.skettios.textadventure.api.command;

import com.skettios.textadventure.api.TextAdventureContainer;

import java.util.List;

public class CommandExit implements ICommand
{
	private TextAdventureContainer container;

	public CommandExit(TextAdventureContainer container)
	{
		this.container = container;
	}

	@Override
	public String[] getCommandAliases()
	{
		return new String[]{ "exit", "quit" };
	}

	@Override
	public void onExecute(List<String> args)
	{
		container.stop();
	}

	@Override
	public boolean canExecute(List<String> args)
	{
		return true;
	}

	@Override
	public String getErrorMessage()
	{
		return "Something wrong happened.";
	}
}
