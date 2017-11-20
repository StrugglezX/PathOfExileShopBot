package poeapi.infrastructure;

import java.util.ArrayList;
import java.util.List;

import poeapi.model.PathOfExileItem;
import poeapi.model.PathOfExileItemModification;
import poeapi.model.PoeTradeSearchParameters;

public class PoeTradeSearchParametersBuilder {

	PoeTradeItemModificationBuilder _itemModificationBuilder;
	
	public PoeTradeSearchParametersBuilder(PoeTradeItemModificationBuilder itemModificationBuilder) {
		super();
		_itemModificationBuilder = itemModificationBuilder;
	}

	public PoeTradeSearchParameters buildParameters(PathOfExileItem item){
		String league = "Standard";
		int requiredLevel = 0;
		int experience = 0;
		int quality = 0;
		List<PathOfExileItemModification> mods = _itemModificationBuilder.buildModifications(item);
		int linkedSocketMinimum = 0;
		if(item.isSixLink()){
			linkedSocketMinimum = 6;
		}
		PoeTradeSearchParameters parameters = new PoeTradeSearchParameters(
				league, 
				item.getTypeLine(), 
				linkedSocketMinimum, 
				requiredLevel, 
				mods, 
				quality, 
				experience, 
				item.getItemLevel(), 
				item.isIdentified(), 
				item.isCorrupted());
		return parameters;
	}
}
