package com.hideleagueicons;

import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Hide League Icons"
)
public class HideLeagueIconsPlugin extends Plugin
{
	@Inject
	private Client client;

	static final private int RELIC_WIDGET_GROUP_ID = 651;
	static final private int RELIC_WIDGET_CHILD_ID = 3;

	@Override
	protected void startUp() throws Exception
	{
		setRelicWidgetHidden(true);
	}

	@Override
	protected void shutDown() throws Exception
	{
		setRelicWidgetHidden(false);
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == RELIC_WIDGET_GROUP_ID)
		{
			setRelicWidgetHidden(true);
		}
	}

	private void setRelicWidgetHidden(boolean b)
	{
		Widget relicWidget = client.getWidget(RELIC_WIDGET_GROUP_ID, RELIC_WIDGET_CHILD_ID);
		if (relicWidget != null)
		{
			relicWidget.setHidden(b);
		}
	}
}
