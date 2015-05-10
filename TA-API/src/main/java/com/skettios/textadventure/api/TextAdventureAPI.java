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

	public static void start(TextAdventureContainer container)
	{
		taContainer = container;
		container.initialize();

		container.start();
	}

	public static void registerCommand(ICommand commandContainer)
	{
		commandRegistry.registerCommand(commandContainer);
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

	public static void setBoolean(String key, boolean flag)
	{
		storyFlagManager.setBoolean(key, flag);
	}

	public static void setInteger(String key, int flag)
	{
		storyFlagManager.setInteger(key, flag);
	}

	public static void setFloat(String key, float flag)
	{
		storyFlagManager.setFloat(key, flag);
	}

	public static void setString(String key, String flag)
	{
		storyFlagManager.setString(key, flag);
	}

	public static boolean getBoolean(String key)
	{
		return storyFlagManager.getBoolean(key);
	}

	public static int getInteger(String key)
	{
		return storyFlagManager.getInteger(key);
	}

	public static float getFloat(String key)
	{
		return storyFlagManager.getFloat(key);
	}

	public static String getString(String key)
	{
		return storyFlagManager.getString(key);
	}

	public static File getSaveDirectory()
	{
		return taContainer.saveDir;
	}
}
