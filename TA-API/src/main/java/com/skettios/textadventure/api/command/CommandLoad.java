package com.skettios.textadventure.api.command;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.JsonValue;
import com.skettios.textadventure.api.TextAdventureAPI;
import com.skettios.textadventure.api.save.EncryptionHelper;
import com.skettios.textadventure.api.story.StoryFlagManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
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
		return new String[]{ "load" };
	}

	@Override
	public void onExecute(List<String> args)
	{
		if (args.size() == 0 || args.size() > 1)
			return;

		File save = new File(TextAdventureAPI.getSaveDirectory() + "/" + args.get(0) + ".sav");
		File tempSave = new File(TextAdventureAPI.getSaveDirectory() + "/" + args.get(0) + "-temp.sav");

		if (!save.exists())
		{
			TextAdventureAPI.sendMessage("The save file, " + args.get(0) + ".sav doesn't exist!");
			return;
		}

		try
		{
			EncryptionHelper.decryptSave(new FileInputStream(save), new FileOutputStream(tempSave));

			if (tempSave.exists())
			{
				Json json = new Json();
				@SuppressWarnings("unchecked")
				ArrayList<JsonValue> ret = json.fromJson(ArrayList.class, new FileReader(tempSave));

				for (JsonValue value : ret)
				{
					if (value != null)
					{
						JsonValue.JsonIterator iterator = value.iterator();
						while (iterator.hasNext())
						{
							if (iterator.next() != null)
							{
								JsonValue currentValue = iterator.next();

								if (currentValue.name().equals("booleans"))
								{
									JsonValue.JsonIterator booleanIter = currentValue.iterator();
									while (booleanIter.hasNext())
									{
										JsonValue innerValue = booleanIter.next();
										if (innerValue != null)
											flagManager.setBoolean(innerValue.name(), innerValue.asBoolean());
									}
								} else if (currentValue.name().equals("integers"))
								{
									JsonValue.JsonIterator integerIter = currentValue.iterator();
									while (integerIter.hasNext())
									{
										JsonValue innerValue = integerIter.next();
										if (innerValue != null)
											flagManager.setInteger(innerValue.name(), innerValue.asInt());
									}
								} else if (currentValue.name().equals("floats"))
								{
									JsonValue.JsonIterator floatIter = currentValue.iterator();
									while (floatIter.hasNext())
									{
										JsonValue innerValue = floatIter.next();
										if (innerValue != null)
											flagManager.setFloat(innerValue.name(), innerValue.asFloat());
									}
								} else if (currentValue.name().equals("strings"))
								{
									JsonValue.JsonIterator stringIter = currentValue.iterator();
									while (stringIter.hasNext())
									{
										JsonValue innerValue = stringIter.next();
										if (innerValue != null)
											flagManager.setString(innerValue.name(), innerValue.asString());
									}
								}
							}
						}
					}
				}
			}

			if (tempSave.exists())
				tempSave.delete();

			TextAdventureAPI.sendMessage("Loaded previous progress from: " + TextAdventureAPI.getSaveDirectory() + "/" + args.get(0) + ".sav");
		}
		catch (Exception ie)
		{
			if (tempSave.exists())
				tempSave.delete();

			TextAdventureAPI.sendMessage("Error loading save from: " + TextAdventureAPI.getSaveDirectory() + "/" + args.get(0) + ".sav... Restart and try again.");
		}
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
