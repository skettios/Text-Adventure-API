package com.skettios.textadventure.api;

import com.skettios.textadventure.api.command.CommandExit;
import com.skettios.textadventure.api.command.CommandRegistry;
import com.skettios.textadventure.api.command.ICommand;
import com.skettios.textadventure.api.item.Item;
import com.skettios.textadventure.api.room.Room;
import com.skettios.textadventure.api.room.RoomRegistry;

public final class TextAdventureAPI
{
	protected static CommandRegistry commandRegistry = new CommandRegistry();
	protected static RoomRegistry roomRegistry = new RoomRegistry();

	public static void start(TextAdventureContainer container)
	{
		registerCommand("exit", new CommandExit(container));

		container.initialize();
		container.start();
	}

	public static void registerCommand(String command, ICommand commandContainer)
	{
		commandRegistry.registerCommand(command, commandContainer);
	}

	public static void registerRoom(Room room)
	{
		roomRegistry.registerRoom(room);
	}

	public static void registerItem(Item item)
	{

	}

	public static void setInvalidCommandMessage(String message)
	{
		commandRegistry.setInvalidCommandMessage(message);
	}
}
