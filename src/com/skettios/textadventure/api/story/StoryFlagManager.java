package com.skettios.textadventure.api.story;

import java.util.HashMap;
import java.util.Map;

public class StoryFlagManager
{
	public Map<String, Boolean> storyBooleanMap = new HashMap<String, Boolean>();
	public Map<String, Integer> storyIntegerMap = new HashMap<String, Integer>();
	public Map<String, Float> storyFloatMap = new HashMap<String, Float>();
	public Map<String, String> storyStringMap = new HashMap<String, String>();

	public void setBoolean(String key, boolean value)
	{
		storyBooleanMap.put(key, value);
	}

	public void setInteger(String key, int value)
	{
		storyIntegerMap.put(key, value);
	}

	public void setFloat(String key, float value)
	{
		storyFloatMap.put(key, value);
	}

	public void setString(String key, String value)
	{
		storyStringMap.put(key, value);
	}

	public boolean getBoolean(String key)
	{
		if (!storyBooleanMap.containsKey(key))
			return false;

		return storyBooleanMap.get(key);
	}

	public int getInteger(String key)
	{
		if (!storyIntegerMap.containsKey(key))
			return -1;

		return storyIntegerMap.get(key);
	}

	public float getFloat(String key)
	{
		if (!storyFloatMap.containsKey(key))
			return -1;

		return storyFloatMap.get(key);
	}

	public String getString(String key)
	{
		if (!storyStringMap.containsKey(key))
			return null;

		return storyStringMap.get(key);
	}
}
