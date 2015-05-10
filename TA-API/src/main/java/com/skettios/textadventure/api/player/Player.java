package com.skettios.textadventure.api.player;

import com.skettios.textadventure.api.item.ItemInventory;

public class Player
{
	private String name;
	private float hp;

	private ItemInventory inventory;

	public Player(String playerName, float hp)
	{
		this.name = playerName;
		this.hp = hp;

		inventory = new ItemInventory(10);
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setHP(float hp)
	{
		this.hp = hp;
	}

	public String getName()
	{
		return name;
	}

	public float getHP()
	{
		return hp;
	}

	public ItemInventory getInventory()
	{
		return inventory;
	}
}
