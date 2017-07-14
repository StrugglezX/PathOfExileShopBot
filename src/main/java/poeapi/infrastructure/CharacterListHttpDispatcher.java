package poeapi.infrastructure;

import java.util.List;

import poeapi.model.PathOfExileApiUrls;
import poeapi.model.PathOfExileCharacterInformation;

public class CharacterListHttpDispatcher {

	PathOfExileApiUrls _urls;
	PathOfExileHttpCookieDispatcher _httpDispatcher;
	JsonToCharacterListParser _characterParser;
	public CharacterListHttpDispatcher(
			PathOfExileApiUrls urls,
			PathOfExileHttpCookieDispatcher httpDispatcher,
			JsonToCharacterListParser characterParser){
		_urls = urls;
		_httpDispatcher = httpDispatcher;
		_characterParser = characterParser;
	}
	
	public List<PathOfExileCharacterInformation> characters(String sessionId)
	{
		String charactersUrl = _urls.charactersUrl();
		String response = _httpDispatcher.getHtmlWithCookie(charactersUrl, sessionId);
		
		List<PathOfExileCharacterInformation> characterList = _characterParser.characters(response);

		return characterList;
	}
}
