package poeapi.infrastructure;

import java.util.List;

import poeapi.model.PathOfExileApiUrls;
import poeapi.model.PathOfExileItem;
import poeapi.model.PathOfExileItemModification;

public class PoeTradeItemDispatcher {

	PathOfExileApiUrls _urls;
	String searchForItem(PathOfExileItem item){
		
		String league = "Legacy";
		List<PathOfExileItemModification> mods = null;
		String url = _urls.poeTradeUrl(
				league, 
				"", 
				0, 
				0, 
				mods, 
				0, 
				0, 
				item.getItemLevel(), 
				item.isIdentified(), 
				item.isCorrupted());
		return url;
	}
}
