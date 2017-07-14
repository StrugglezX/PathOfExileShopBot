package poeapi.infrastructure;

import java.util.List;

import poeapi.model.PathOfExileApiUrls;
import poeapi.model.PathOfExileItem;
import poeapi.model.PathOfExileTabInformation;

public class StashTabHttpDispatcher {

	PathOfExileApiUrls _urls;
	PathOfExileHttpCookieDispatcher _httpDispatcher;
	JsonToTabListParser _tabListJsonParser;
	JsonItemArrayToItemListParser _tabItemListParser;
	public StashTabHttpDispatcher(PathOfExileApiUrls urls,
			PathOfExileHttpCookieDispatcher httpDispatcher,
			JsonToTabListParser tabListJsonParser,
			JsonItemArrayToItemListParser tabItemListParser){
		_urls = urls;
		_httpDispatcher = httpDispatcher;
		_tabItemListParser = tabItemListParser;
		_tabListJsonParser = tabListJsonParser;
	}

	public List<PathOfExileTabInformation> getTabs(String league, String accountName, String sessionId){
		String tabsUrl = _urls.tabsUrl(league, accountName);
		String response = _httpDispatcher.getHtmlWithCookie(tabsUrl, sessionId);
		List<PathOfExileTabInformation> tabs = _tabListJsonParser.getTabs(response);
		return tabs;
	}
	
	public List<PathOfExileItem> getItemsFromStashTab(
			String league, 
			String accountName, 
			int tabIndex, 
			String sessionId){
		String stashUrl = _urls.stashUrl(league, tabIndex, accountName);
//		System.out.println("StashTabHttpDispatcher '" + stashUrl + "'");
		String response = _httpDispatcher.getHtmlWithCookie(stashUrl, sessionId);
		List<PathOfExileItem> items = _tabItemListParser.getItemsFromJsonItemList(response);
		return items;
	}
}
