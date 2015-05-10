package com.skettios.textadventure.command;

import com.skettios.textadventure.api.TextAdventureAPI;
import com.skettios.textadventure.api.command.ICommand;

import java.util.List;

public class CommandSeanman implements ICommand
{
	@Override
	public String[] getCommandAliases()
	{
		return new String[]{ "seanman", "steven", "seanmang", "seansteve" };
	}

	@Override
	public void onExecute(List<String> args)
	{
		TextAdventureAPI.sendMessage("You have just killed yourself kiddo.");
	}

	@Override
	public boolean canExecute(List<String> args)
	{
		return true;
	}

	@Override
	public String getErrorMessage(List<String> args)
	{
		return null;
	}
}
