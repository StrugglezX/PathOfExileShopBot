package poeapi.infrastructure;

import java.util.ArrayList;
import java.util.List;

import poeapi.model.PathOfExileCharacter;
import poeapi.model.PathOfExileCharacterInformation;
import poeapi.model.PathOfExileItem;

public class PathOfExileLeagueCharacterBuilder {

	private CharacterInventoryHttpDispatcher _inventoryParser;
	
	
	public PathOfExileLeagueCharacterBuilder(CharacterInventoryHttpDispatcher inventoryParser) {
		_inventoryParser = inventoryParser;
	}


	public List<PathOfExileCharacter> getLeagueCharacters(
			List<PathOfExileCharacterInformation> characters, 
			String accountName, 
			String sessionId,
			String leagueName){
		List<PathOfExileCharacter> leagueCharacters = new ArrayList<PathOfExileCharacter>();
		for(PathOfExileCharacterInformation characterInformation : characters){
			if(characterInformation.getLeague().equals(leagueName)){
				List<PathOfExileItem> characterInventory = _inventoryParser.getInventory(accountName, sessionId, characterInformation.getName());
				PathOfExileCharacter leagueCharacter = new PathOfExileCharacter(characterInformation, characterInventory);
				leagueCharacters.add(leagueCharacter);
			}
		}
		return leagueCharacters;
	}
}
