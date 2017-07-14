package poeapi.infrastructure;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import poeapi.model.PathOfExileCharacterInformation;

public class PathOfExileLeagueNameParser {

	public Set<String> parseLeagues(List<PathOfExileCharacterInformation> characters){
		Set<String> leagueNames = new HashSet<String>();
		for(PathOfExileCharacterInformation character : characters){
			String leagueName = character.getLeague();
			leagueNames.add(leagueName);
		}
		return leagueNames;
	}
}