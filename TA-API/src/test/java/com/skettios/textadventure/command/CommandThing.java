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
		TextAdventureAPI.sendMessage("Setting test-bool to " + args.get(0));
		if (args.get(0).equals("true"))
			TextAdventureAPI.setBoolean("test-bool", true);
		else
			TextAdventureAPI.setBoolean("test-bool", false);
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
