package poeapi.infrastructure;

import java.util.ArrayList;
import java.util.List;

import poeapi.model.PathOfExileTab;
import poeapi.model.PathOfExileTabInformation;

public class PathOfExileStashTabListBuilder {

	private PathOfExileTabParser _tabParser;
	
	public PathOfExileStashTabListBuilder(PathOfExileTabParser tabParser) {
		_tabParser = tabParser;
	}

	public List<PathOfExileTab> getStashTabs(
			String accountName, 
			String sessionId, 
			String leagueName, 
			List<PathOfExileTabInformation> tabs){
		List<PathOfExileTab> stashTabs = new ArrayList<PathOfExileTab>();
		for(PathOfExileTabInformation tabInformation : tabs){
			PathOfExileTab tab = _tabParser.getTab(
					accountName, sessionId, leagueName, tabInformation);
			stashTabs.add(tab);
		}
		return stashTabs;
	}
}
