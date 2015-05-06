package com.skettios.textadventure.command;

import com.skettios.textadventure.api.TextAdventureAPI;
import com.skettios.textadventure.api.command.ICommand;

import java.util.List;

public class CommandThing implements ICommand
{
	@Override
	public String[] getCommandAliases()
	{
		return new String[]{ "thing" };
	}

	@Override
	public void onExecute(List<String> args)
	{
		TextAdventureAPI.sendMessage("Setting test-boolean to " + args.get(0));
		if (args.get(0).equals("true"))
			TextAdventureAPI.setBoolean("test-boolean", true);
		else
			TextAdventureAPI.setBoolean("test-boolean", false);
	}

	@Override
	public boolean canExecute(List<String> args)
	{
		return true;
	}

	@Override
	public String getErrorMessage()
	{
		return null;
	}
}
