package com.skettios.textadventure;

import com.skettios.textadventure.api.TextAdventureContainer;

import java.util.List;

public class SkettiosTextAdventure extends TextAdventureContainer
{
	@Override
	public void parseCommand(String command, List<String> args)
	{
		switch(command)
		{
			case "lel":
				System.out.println("lol");
				break;
			default:
				System.out.println("You can't do that.");
				break;
		}
	}
}
