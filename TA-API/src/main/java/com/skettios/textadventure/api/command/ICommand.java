package com.skettios.textadventure.api.command;

import java.util.List;

public interface ICommand
{
	String[] getCommandAliases();

	void onExecute(List<String> args);

	boolean canExecute(List<String> args);

	String getErrorMessage(List<String> args);
}
