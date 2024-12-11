package com.hideleagueicons;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class HideLeagueIconsTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(HideLeagueIconsPlugin.class);
		RuneLite.main(args);
	}
}