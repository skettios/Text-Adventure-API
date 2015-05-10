package com.skettios.textadventure;

import com.skettios.textadventure.api.TextAdventureAPI;

public class Start
{
	public static void main(String[] args)
	{
		TextAdventureAPI.start(new SkettiosTextAdventure("Test Adventure", "saves"));
	}
}
