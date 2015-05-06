package com.skettios.textadventure;

import com.skettios.textadventure.api.TextAdventureAPI;
import com.skettios.textadventure.api.TextAdventureContainer;
import com.skettios.textadventure.command.*;

public class SkettiosTextAdventure extends TextAdventureContainer
{
	@Override
	public void initialize()
	{
		TextAdventureAPI.registerCommand(new CommandTest());
		TextAdventureAPI.registerCommand(new CommandThing());
		TextAdventureAPI.registerCommand(new CommandSeanman());
		TextAdventureAPI.registerCommand(new CommandJeric());
		TextAdventureAPI.registerCommand(new CommandTeara());
		TextAdventureAPI.registerCommand(new CommandAdd());

		TextAdventureAPI.setBoolean("test-bool", false);
		TextAdventureAPI.setInteger("test-int", 1000);
		TextAdventureAPI.setFloat("test-float", 0.4f);
		TextAdventureAPI.setString("test-string", "this is a test");
		TextAdventureAPI.setInteger("adding-thing", 0);

		TextAdventureAPI.setInvalidCommandMessage("LOL WUAT");
	}
}
