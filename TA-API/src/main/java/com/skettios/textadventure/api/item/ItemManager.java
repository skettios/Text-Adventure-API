package com.skettios.textadventure.api.item;

import java.util.HashMap;
import java.util.Map;

public final class ItemManager
{
	private static Map<Integer, Item> items = new HashMap<Integer, Item>();

	public static void registerItem(Item item)
	{
		if (items.containsKey(item.getItemId()))
			return;

		items.put(item.getItemId(), item);
	}

	public static void activateItem(int itemId)
	{
		if (!items.containsKey(itemId))
			return;

		items.get(itemId).onActivate();
	}
}
