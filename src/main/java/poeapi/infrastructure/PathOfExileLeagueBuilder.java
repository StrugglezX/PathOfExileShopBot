package poeapi.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import poeapi.model.PathOfExileCharacter;
import poeapi.model.PathOfExileCharacterInformation;
import poeapi.model.PathOfExileLeague;
import poeapi.model.PathOfExileTab;

public class PathOfExileLeagueBuilder {

	private PathOfExileLeagueNameParser _leagueParser;
	private PathOfExileStashTabBuilder _stashTabBuilder;
	private PathOfExileLeagueCharacterBuilder _leagueCharacterBuilder;
	
	public PathOfExileLeagueBuilder(PathOfExileLeagueNameParser leagueParser,
			PathOfExileStashTabBuilder stashTabBuilder, PathOfExileLeagueCharacterBuilder leagueCharacterBuilder) {
		_leagueParser = leagueParser;
		_stashTabBuilder = stashTabBuilder;
		_leagueCharacterBuilder = leagueCharacterBuilder;
	}

	public List<PathOfExileLeague> buildLeague(
			List<PathOfExileCharacterInformation> characters, 
			String accountName, 
			String sessionId){
		Set<String> leagueNames = _leagueParser.parseLeagues(characters);
		
		List<PathOfExileLeague> leagues = new ArrayList<PathOfExileLeague>();
		for(String leagueName : leagueNames){
			List<PathOfExileTab> stashTabs = _stashTabBuilder.getStashTabs(accountName, sessionId, leagueName);
			List<PathOfExileCharacter> leagueCharacters = _leagueCharacterBuilder.getLeagueCharacters(
					characters, accountName, sessionId, leagueName);
			PathOfExileLeague league = new PathOfExileLeague(leagueName, stashTabs, leagueCharacters);
			leagues.add(league);
		}
		return leagues;
	}
}
