package com.skettios.textadventure.command;

import com.skettios.textadventure.api.TextAdventureAPI;
import com.skettios.textadventure.api.command.ICommand;

import java.util.List;

public class CommandAdd implements ICommand
{
	@Override
	public String[] getCommandAliases()
	{
		return new String[]{ "add" };
	}

	@Override
	public void onExecute(List<String> args)
	{
		if (args.isEmpty() || args.size() > 1)
			return;

		int input = Integer.parseInt(args.get(0));
		TextAdventureAPI.setInteger("adding-thing", TextAdventureAPI.getInteger("adding-thing") + input);
		TextAdventureAPI.sendMessage("The new value of \"adding-thing\" is " + TextAdventureAPI.getInteger("adding-thing"));
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
