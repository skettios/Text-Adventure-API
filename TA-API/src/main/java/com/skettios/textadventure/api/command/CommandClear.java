package com.skettios.textadventure.api.command;

import com.skettios.textadventure.api.TextAdventureUI;

import java.util.List;

public class CommandClear implements ICommand
{
	private TextAdventureUI ui;

	public CommandClear(TextAdventureUI ui)
	{
		this.ui = ui;
	}

	@Override
	public String[] getCommandAliases()
	{
		return new String[]{ "clear" };
	}

	@Override
	public void onExecute(List<String> args)
	{
		ui.clearConsole();
	}

	@Override
	public boolean canExecute(List<String> args)
	{
		return true;
	}

	@Override
	public String getErrorMessage()
	{
		return "Something went wrong!";
	}
}
