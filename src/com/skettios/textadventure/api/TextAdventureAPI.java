package com.skettios.textadventure.api;

import com.skettios.textadventure.api.command.CommandRegistry;
import com.skettios.textadventure.api.command.ICommand;
import com.skettios.textadventure.api.item.Item;
import com.skettios.textadventure.api.room.Room;

public final class TextAdventureAPI
{
	protected static CommandRegistry commandRegistry;

	public static void start(TextAdventureContainer container)
	{
		// Pre-Pre-Initialize game registries.
		commandRegistry = new CommandRegistry();

		container.preInit();
		container.init();
		container.test();
	}

	public static void registerCommand(String command, ICommand commandContainer)
	{
		commandRegistry.registerCommand(command, commandContainer);
	}

	public static void registerRoom(Room room)
	{

	}

	public static void registerItem(Item item)
	{

	}
}
