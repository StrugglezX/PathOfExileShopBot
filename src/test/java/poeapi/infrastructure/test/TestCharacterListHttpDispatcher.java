package poeapi.infrastructure.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poeapi.infrastructure.CharacterListHttpDispatcher;
import poeapi.infrastructure.JsonToCharacterListParser;
import poeapi.infrastructure.PathOfExileHttpCookieDispatcher;
import poeapi.model.PathOfExileApiUrls;
import poeapi.model.PathOfExileCharacterInformation;
import poetest.PoeTest;

public class TestCharacterListHttpDispatcher {

	PathOfExileApiUrls _urls;
	PathOfExileHttpCookieDispatcher _httpDispatcher;
	JsonToCharacterListParser _characterParser;
	CharacterListHttpDispatcher _patient;
	@Before
	public void setUp() throws Exception {
		_urls = mock(PathOfExileApiUrls.class);
		_httpDispatcher = mock(PathOfExileHttpCookieDispatcher.class);
		_characterParser = mock(JsonToCharacterListParser.class);
		_patient = new CharacterListHttpDispatcher(_urls, _httpDispatcher, _characterParser);
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
		_characterParser = null;
		_httpDispatcher = null;
		_urls = null;
	}

	@Test
	public void testGetCharactersWillUseCharacterUrlWithSessionId() {
		String characterUrl = new String("characterUrl");
		String sessionId = new String("my id");
		when(_urls.charactersUrl()).thenReturn(characterUrl);
		
		_patient.characters(sessionId);
		
		verify(_httpDispatcher).getHtmlWithCookie(characterUrl, sessionId);
	}

	@Test
	public void testCharactersWillGiveHttpResponseToParser(){
		String httpPostResponse = new String("my response");
		when(_httpDispatcher.getHtmlWithCookie(any(), any())).thenReturn(httpPostResponse);
		
		_patient.characters("");
		
		verify(_characterParser).characters(httpPostResponse);
	}
	
	@Test
	public void testCharactersWillForwardCharactersFromParser(){
		List<PathOfExileCharacterInformation> expectedCharacters = new ArrayList<PathOfExileCharacterInformation>();
		expectedCharacters.add(new PathOfExileCharacterInformation("name", "league", 1, 2, "class", 3));
		when(_characterParser.characters(any())).thenReturn(expectedCharacters);
		
		List<PathOfExileCharacterInformation> actualCharacters = _patient.characters(""); 
		
		PoeTest.verifyEquals(actualCharacters, expectedCharacters);
	}
	
}
