package com.skettios.textadventure.command;

import com.skettios.textadventure.api.TextAdventureAPI;
import com.skettios.textadventure.api.command.ICommand;

import java.util.List;

public class CommandTeara implements ICommand
{
	@Override
	public String[] getCommandAliases()
	{
		return new String[]{ "teara", "mischu" };
	}

	@Override
	public void onExecute(List<String> args)
	{
		TextAdventureAPI.sendMessage("I lost my knife. KEK");
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
