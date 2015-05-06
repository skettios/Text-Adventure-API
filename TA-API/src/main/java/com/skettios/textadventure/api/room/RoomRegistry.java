package com.skettios.textadventure.api.room;

import java.util.HashMap;
import java.util.Map;

public class RoomRegistry
{
	private Map<String, Room> roomMap = new HashMap<String, Room>();

	public void registerRoom(Room room)
	{
		roomMap.put(room.getRoomName(), room);
	}
}
