package com.skettios.textadventure.command;

import com.skettios.textadventure.api.TextAdventureAPI;
import com.skettios.textadventure.api.command.ICommand;

import java.util.List;

public class CommandJeric implements ICommand
{
	@Override
	public String[] getCommandAliases()
	{
		return new String[]{ "jeric", "ako-si-jeric", "ako-si-silver" };
	}

	@Override
	public void onExecute(List<String> args)
	{
		for (String arg : args)
		{
			if (arg.equals("silver"))
				TextAdventureAPI.sendMessage("KEK");

			if (arg.equals("csgo"))
				TextAdventureAPI.sendMessage("I suck at this.");

			if (arg.equals("carry"))
				TextAdventureAPI.sendMessage("Haha, Good One. LOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOL");
		}
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
