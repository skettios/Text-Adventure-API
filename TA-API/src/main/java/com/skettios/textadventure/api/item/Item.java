package com.skettios.textadventure.api.item;

public abstract class Item
{
	private int itemId;

	public Item(int id)
	{
		itemId = id;
	}

	public int getItemId()
	{
		return itemId;
	}

	public abstract void onActivate();
}
