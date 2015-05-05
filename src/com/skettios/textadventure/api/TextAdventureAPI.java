package com.skettios.textadventure.api;

import com.skettios.textadventure.api.command.CommandRegistry;
import com.skettios.textadventure.api.command.ICommand;
import com.skettios.textadventure.api.item.Item;
import com.skettios.textadventure.api.room.Room;
import com.skettios.textadventure.api.room.RoomRegistry;
import com.skettios.textadventure.api.story.StoryFlagManager;

import java.io.File;

public final class TextAdventureAPI
{
	protected static CommandRegistry commandRegistry = new CommandRegistry();
	protected static RoomRegistry roomRegistry = new RoomRegistry();
	protected static StoryFlagManager storyFlagManager = new StoryFlagManager();

	private static TextAdventureContainer taContainer;

	public static void start(String title, TextAdventureContainer container)
	{
		taContainer = container;
		container.initialize();

		if (!new File("saves").exists())
			new File("saves").mkdir();

		container.start(title);
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

	public static void sendMessage(String message)
	{
		taContainer.ui.sendMessage(message);
	}

	public static void setInvalidCommandMessage(String message)
	{
		commandRegistry.setInvalidCommandMessage(message);
	}

	public static void setStoryBoolean(String key, boolean flag)
	{
		storyFlagManager.setBoolean(key, flag);
	}

	public static void setStoryInteger(String key, int flag)
	{
		storyFlagManager.setInteger(key, flag);
	}

	public static void setStoryFloat(String key, float flag)
	{
		storyFlagManager.setFloat(key, flag);
	}

	public static void setStoryString(String key, String flag)
	{
		storyFlagManager.setString(key, flag);
	}
}
