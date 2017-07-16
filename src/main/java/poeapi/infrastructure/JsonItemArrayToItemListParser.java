package poeapi.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import poeapi.model.PathOfExileItem;

public class JsonItemArrayToItemListParser {
	static final Logger LOGGER = LogManager.getLogger(JsonItemArrayToItemListParser.class);

	public List<PathOfExileItem> getItemsFromJsonItemList(String json){
		List<PathOfExileItem> items = new ArrayList<PathOfExileItem>();
		JSONObject entireJson = new JSONObject(json);
		LOGGER.info(String.format("\n%s", entireJson.toString(3)));
		JSONArray jsonItems = entireJson.getJSONArray("items");
		LOGGER.debug("List<PathOfExileItem> items = new ArrayList<PathOfExileItem>();\n");
		for(int i = 0; i < jsonItems.length(); i++){
			JSONObject jsonItem = jsonItems.getJSONObject(i);
			PathOfExileItem item = getItemFromJson(jsonItem);
			items.add(item);
			LOGGER.debug(item.debugToString("items"));
		}
		return items;
	}
	
	private PathOfExileItem getItemFromJson(JSONObject json){
		int width = json.getInt("w");
		int height = json.getInt("h");
		int itemLevel = json.getInt("ilvl");
		String icon = json.getString("icon");
		JSONArray jsonSockets = json.getJSONArray("sockets");
		List<String> sockets = new ArrayList<String>(); 
		for(int i = 0; i < jsonSockets.length(); i++){
			JSONObject socket = jsonSockets.getJSONObject(i);
			String attribute = socket.getString("attr");
			sockets.add(attribute);
		}
		String name = json.getString("name");
		String typeLine = json.getString("typeLine");
		boolean corrupted = json.getBoolean("corrupted");
		boolean identified = json.getBoolean("identified");
		List<String> implicitMods = new ArrayList<String>();
		if(json.has("implicitMods")){
			JSONArray jsonImplicitMods = json.getJSONArray("implicitMods");
			for(int i = 0; i < jsonImplicitMods.length(); i++){
				String implicitMod = jsonImplicitMods.getString(i);
				implicitMods.add(implicitMod);
			}
		}
		List<String> explicitMods = new ArrayList<String>();
		if(json.has("explicitMods")){
			JSONArray jsonExplicitMods = json.getJSONArray("explicitMods");
			for(int i = 0; i < jsonExplicitMods.length(); i++){
				String explicitMod = jsonExplicitMods.getString(i);
				explicitMods.add(explicitMod);
			}
		}
		int xLocation = -1;
		if(json.has("x")){
			xLocation = json.getInt("x");
		}
		int yLocation = -1;
		if(json.has("y")){
			yLocation = json.getInt("y");
		}
		JSONArray jsonSocketedItems = json.getJSONArray("socketedItems");
		List<PathOfExileItem> socketedItems = new ArrayList<PathOfExileItem>();
		for(int i = 0; i < jsonSocketedItems.length(); i++){
			JSONObject jsonSocketedItem = jsonSocketedItems.getJSONObject(i);
			PathOfExileItem socketedItem = getItemFromJson(jsonSocketedItem);
			socketedItems.add(socketedItem);
		}
		PathOfExileItem item = new PathOfExileItem(
				width,
				height,
				itemLevel,
				icon,
				sockets,
				name,
				typeLine,
				corrupted,
				identified,
				implicitMods,
				explicitMods,
				xLocation,
				yLocation,
				socketedItems);
		return item;
	}
	
}
