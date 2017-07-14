package poeapi.infrastructure;

import java.util.List;

import poeapi.model.PathOfExileTab;
import poeapi.model.PathOfExileTabInformation;

public class PathOfExileStashTabBuilder {

	private StashTabHttpDispatcher _characterItemsDispatcher;
	private PathOfExileStashTabListBuilder _stashTabListBuilder;
	public PathOfExileStashTabBuilder(
			StashTabHttpDispatcher characterItemsDispatcher,
			PathOfExileStashTabListBuilder stashTabListBuilder) {
		_characterItemsDispatcher = characterItemsDispatcher;
		_stashTabListBuilder = stashTabListBuilder;
	}
	public List<PathOfExileTab> getStashTabs(
			String accountName, 
			String sessionId, 
			String leagueName){
		List<PathOfExileTabInformation> tabs = _characterItemsDispatcher.getTabs(leagueName, accountName, sessionId);
		List<PathOfExileTab> stashTabs = _stashTabListBuilder.getStashTabs(accountName, sessionId, leagueName, tabs);
		return stashTabs;
	}
}
