package poeapi.infrastructure;

import java.util.List;

import poeapi.model.PathOfExileAccount;
import poeapi.model.PathOfExileCharacterInformation;
import poeapi.model.PathOfExileLeague;

public class PathOfExileAccountBuilder {

	private CharacterListHttpDispatcher _characterListDispatcher;
	private PathOfExileLeagueBuilder _leagueBuilder;
	
	public PathOfExileAccountBuilder(
			CharacterListHttpDispatcher characterListDispatcher,
			PathOfExileLeagueBuilder leagueBuilder) {
		_characterListDispatcher = characterListDispatcher;
		_leagueBuilder = leagueBuilder;
	}

	public PathOfExileAccount buildAccount(String accountName, String sessionId){
		List<PathOfExileCharacterInformation> characters = _characterListDispatcher.characters(sessionId);
		List<PathOfExileLeague> leagues = _leagueBuilder.buildLeague(characters, accountName, sessionId);
		PathOfExileAccount account = new PathOfExileAccount(leagues, accountName, sessionId);
		return account;
	}
}
