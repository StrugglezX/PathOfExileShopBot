package poeapi.infrastructure;

import java.util.List;

import poeapi.model.PathOfExileApiUrls;
import poeapi.model.PathOfExileItem;

public class CharacterInventoryHttpDispatcher {

	PathOfExileApiUrls _urls;
	PathOfExileHttpCookieDispatcher _httpDispatcher;
	JsonItemArrayToItemListParser _itemListParser;
	
	public CharacterInventoryHttpDispatcher(PathOfExileApiUrls urls, PathOfExileHttpCookieDispatcher httpDispatcher,
			JsonItemArrayToItemListParser itemListParser) {
		super();
		_urls = urls;
		_httpDispatcher = httpDispatcher;
		_itemListParser = itemListParser;
	}

	public List<PathOfExileItem> getInventory(String accountName, String sessionId, String characterName){
		String inventoryUrl = _urls.inventortyUrl(accountName, characterName);
		String response = _httpDispatcher.getHtmlWithCookie(inventoryUrl, sessionId);
		List<PathOfExileItem> items = _itemListParser.getItemsFromJsonItemList(response);
		return items;
	}
}
