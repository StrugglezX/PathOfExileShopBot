package poeapi.infrastructure;

import java.util.List;

import poeapi.model.PathOfExileItem;
import poeapi.model.PathOfExileTab;
import poeapi.model.PathOfExileTabInformation;

public class PathOfExileTabParser {
	private StashTabHttpDispatcher _characterItemsDispatcher;
	public PathOfExileTabParser(StashTabHttpDispatcher characterItemsDispatcher) {
		_characterItemsDispatcher = characterItemsDispatcher;
	}
	public PathOfExileTab getTab(String accountName, String sessionId, String leagueName, PathOfExileTabInformation tabInformation)
	{
		List<PathOfExileItem> tabItems = _characterItemsDispatcher.getItemsFromStashTab(
				leagueName, accountName, tabInformation.getIndex(), sessionId);
		PathOfExileTab tab = new PathOfExileTab(tabInformation, tabItems);
		return tab;
	}
}
