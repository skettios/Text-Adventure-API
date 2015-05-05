package com.skettios.textadventure.api.command;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.JsonValue;
import com.skettios.textadventure.api.TextAdventureAPI;
import com.skettios.textadventure.api.save.SaveHelper;
import com.skettios.textadventure.api.story.StoryFlagManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CommandLoad implements ICommand
{
	private StoryFlagManager flagManager;

	public CommandLoad(StoryFlagManager flagManager)
	{
		this.flagManager = flagManager;
	}

	@Override
	public String[] getCommandAliases()
	{
		return new String[]{"load"};
	}

	@Override
	public void onExecute(List<String> args)
	{
		try
		{
			SaveHelper.decryptSave(new FileInputStream("saves/" + args.get(0) + ".sav"), new FileOutputStream("saves/" + args.get(0) + "-temp.sav"));

			Json json = new Json();
			ArrayList<JsonValue> ret = json.fromJson(ArrayList.class, new FileReader("saves/" + args.get(0) + "-temp.sav"));

			for (JsonValue value : ret)
			{
				if (ret != null)
				{
					JsonValue.JsonIterator iterator = value.iterator();
					while (iterator.hasNext())
					{
						JsonValue currentValue = iterator.next();
						if (currentValue.name().equals("booleans"))
						{
							JsonValue.JsonIterator booleanIter = currentValue.iterator();
							while (booleanIter.hasNext())
							{
								JsonValue innerValue = booleanIter.next();
								System.out.println("Key: " + innerValue.name() + " Value: " + innerValue.asBoolean());
								flagManager.setBoolean(innerValue.name(), innerValue.asBoolean());
							}
						}

						if (currentValue.name().equals("integers"))
						{
							JsonValue.JsonIterator integerIter = currentValue.iterator();
							while (integerIter.hasNext())
							{
								JsonValue innerValue = integerIter.next();
								System.out.println("Key: " + innerValue.name() + "\tValue: " + innerValue.asInt());
								flagManager.setInteger(innerValue.name(), innerValue.asInt());
							}
						}

						if (currentValue.name().equals("floats"))
						{
							JsonValue.JsonIterator floatIter = currentValue.iterator();
							while (floatIter.hasNext())
							{
								JsonValue innerValue = floatIter.next();
								System.out.println("Key: " + innerValue.name() + "\tValue: " + innerValue.asFloat());
								flagManager.setFloat(innerValue.name(), innerValue.asFloat());
							}
						}

						if (currentValue.name().equals("strings"))
						{
							JsonValue.JsonIterator stringIter = currentValue.iterator();
							while (stringIter.hasNext())
							{
								JsonValue innerValue = stringIter.next();
								System.out.println("Key: " + innerValue.name() + "\tValue: " + innerValue.asString());
								flagManager.setString(innerValue.name(), innerValue.asString());
							}
						}
					}
				}
			}

			new File("saves/" + args.get(0) + "-temp.sav").delete();
			TextAdventureAPI.sendMessage("Loaded previous progress from: saves/" + args.get(0) + ".sav");
		}
		catch (IOException e)
		{
			new File("saves/" + args.get(0) + "-temp.sav").delete();
			TextAdventureAPI.sendMessage("Error loading save from: saves/" + args.get(0) + ".sav... Restart and try again.");
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
