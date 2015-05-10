package com.skettios.textadventure.command;

import com.skettios.textadventure.api.TextAdventureAPI;
import com.skettios.textadventure.api.command.ICommand;

import java.util.List;

public class CommandTest implements ICommand
{
	@Override
	public String[] getCommandAliases()
	{
		return new String[]{ "test" };
	}

	@Override
	public void onExecute(List<String> args)
	{
		TextAdventureAPI.sendMessage("test...");
	}

	@Override
	public boolean canExecute(List<String> args)
	{
		return true;
	}

	@Override
	public String getErrorMessage(List<String> args)
	{
		return "You do not have something idk?";
	}
}
