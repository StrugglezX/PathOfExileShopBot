package poeapi.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import poeapi.model.PathOfExileCharacterInformation;

public class JsonToCharacterListParser {

	public List<PathOfExileCharacterInformation> characters(String json){
		json = "{\"characters\":" + json + "}";
		List<PathOfExileCharacterInformation> characters = new ArrayList<PathOfExileCharacterInformation>();
		JSONObject entireJson = new JSONObject(json);
		JSONArray arrayOfCharacters = entireJson.getJSONArray("characters");
		for(int i = 0; i < arrayOfCharacters.length(); i++){
			JSONObject characterJson = arrayOfCharacters.getJSONObject(i);
			PathOfExileCharacterInformation character = new PathOfExileCharacterInformation(
					characterJson.getString("name"),
					characterJson.getString("league"),
					characterJson.getInt("classId"),
					characterJson.getInt("ascendancyClass"),
					characterJson.getString("class"),
					characterJson.getInt("level")
					);
			characters.add(character);
		}
		return characters;
	}
	
}
