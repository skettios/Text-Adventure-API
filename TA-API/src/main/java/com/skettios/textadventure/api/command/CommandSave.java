package com.skettios.textadventure.api.command;

import com.google.gson.stream.JsonWriter;
import com.skettios.textadventure.api.TextAdventureAPI;
import com.skettios.textadventure.api.save.EncryptionHelper;
import com.skettios.textadventure.api.story.StoryFlagManager;

import java.io.*;
import java.util.List;

public class CommandSave implements ICommand
{
	private StoryFlagManager flagManager;

	public CommandSave(StoryFlagManager flagManager)
	{
		this.flagManager = flagManager;
	}

	@Override
	public String[] getCommandAliases()
	{
		return new String[]{ "save" };
	}

	@Override
	public void onExecute(List<String> args)
	{
		if ((args.isEmpty() || args.get(0) == null) || (args.size() > 1 || args.size() == 0))
		{
			TextAdventureAPI.sendMessage("save - saves your current progress. (args (1): save file)");
			return;
		}

		try
		{
			if (new File("saves/" + args.get(0)).exists())
				EncryptionHelper.decryptSave(new FileInputStream(TextAdventureAPI.getSaveDirectory() + "/" + args.get(0) + ".sav"), new FileOutputStream(TextAdventureAPI.getSaveDirectory() + "/" + args.get(0) + "-temp.sav"));

			FileOutputStream out = new FileOutputStream(TextAdventureAPI.getSaveDirectory() + "/" + args.get(0) + "-temp.sav");
			JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
			writer.setIndent("	");

			writer.beginArray();
			{
				writer.beginObject();
				{
					writer.name("booleans");
					writer.beginObject();
					{
						for (String key : flagManager.storyBooleanMap.keySet())
							writer.name(key).value(flagManager.getBoolean(key));
					}
					writer.endObject();

					writer.name("integers");
					writer.beginObject();
					{
						for (String key : flagManager.storyIntegerMap.keySet())
							writer.name(key).value(flagManager.getInteger(key));
					}
					writer.endObject();

					writer.name("floats");
					writer.beginObject();
					{
						for (String key : flagManager.storyFloatMap.keySet())
							writer.name(key).value(flagManager.getFloat(key));
					}
					writer.endObject();

					writer.name("strings");
					writer.beginObject();
					{
						for (String key : flagManager.storyStringMap.keySet())
							writer.name(key).value(flagManager.storyStringMap.get(key));
					}
					writer.endObject();
				}
				writer.endObject();
			}
			writer.endArray();

			writer.flush();
			out.close();

			EncryptionHelper.encryptSave(new FileInputStream(TextAdventureAPI.getSaveDirectory() + "/" + args.get(0) + "-temp.sav"), new FileOutputStream(TextAdventureAPI.getSaveDirectory() + "/" + args.get(0) + ".sav"));

//			new File(TextAdventureAPI.getSaveDirectory() + "/" + args.get(0) + "-temp.sav").delete();

			TextAdventureAPI.sendMessage("Saved current progress to: " + TextAdventureAPI.getSaveDirectory() + "/" + args.get(0) + ".sav");
		}
		catch (IOException e)
		{
			TextAdventureAPI.sendMessage("Problem saving current progress... You're screwed...");
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
