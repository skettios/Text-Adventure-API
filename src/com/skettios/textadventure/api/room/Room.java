package com.skettios.textadventure.api.room;

import java.util.ArrayList;
import java.util.List;

public abstract class Room
{
	private String roomName;
	private List<Room> roomExits;

	public Room(String roomName)
	{
		this.roomName = roomName;
		roomExits = new ArrayList<Room>();
	}

	public String getRoomName()
	{
		return roomName;
	}

	public void setRoomExits(Room... rooms)
	{
		for (Room room : rooms)
			addRoomExit(room);
	}

	public void addRoomExit(Room room)
	{
		roomExits.add(room);
	}

	public List<Room> getRoomExits()
	{
		return roomExits;
	}
}
