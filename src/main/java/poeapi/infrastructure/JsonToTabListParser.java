package poeapi.infrastructure;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import poeapi.model.PathOfExileTabInformation;

public class JsonToTabListParser {

	public List<PathOfExileTabInformation> getTabs(String json){
		json = "{\"tabs\":" + json + "}";
		List<PathOfExileTabInformation> tabs = new ArrayList<PathOfExileTabInformation>();
		JSONObject entireJson = new JSONObject(json);
		JSONObject tabsObject = entireJson.getJSONObject("tabs");
		JSONArray arrayOfTabs = tabsObject.getJSONArray("tabs");
		for(int i = 0; i < arrayOfTabs.length(); i++){
			JSONObject tabJson = arrayOfTabs.getJSONObject(i);
			JSONObject color = tabJson.getJSONObject("colour");
			PathOfExileTabInformation character = new PathOfExileTabInformation(
					tabJson.getString("n"),
					tabJson.getInt("i"),
					tabJson.getString("id"),
					tabJson.getString("type"),
					tabJson.getBoolean("hidden"),
					tabJson.getBoolean("selected"),
					new Color(color.getInt("r"), color.getInt("g"), color.getInt("b")),
					tabJson.getString("srcL"),
					tabJson.getString("srcC"),
					tabJson.getString("srcR")
					);
			tabs.add(character);
		}
		return tabs;
	}
}
