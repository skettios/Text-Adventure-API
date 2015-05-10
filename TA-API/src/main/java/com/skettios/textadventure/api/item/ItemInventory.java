package com.skettios.textadventure.api.item;

import com.skettios.textadventure.api.item.Item;

public class ItemInventory
{
	private int inventorySlots;
	private Item[] inventory;

	public ItemInventory(int slots)
	{
		this.inventorySlots = slots;
		inventory = new Item[slots];
	}

	public int getSlotAmount()
	{
		return inventorySlots;
	}

	public Item getItemAtSlot(int slot)
	{
		return inventory[slot] != null ? inventory[slot] : null;
	}
}
