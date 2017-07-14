package poeapi.infrastructure.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import java.util.ArrayList;
import java.util.List;


import poeapi.infrastructure.CharacterListHttpDispatcher;
import poeapi.infrastructure.PathOfExileAccountBuilder;
import poeapi.infrastructure.PathOfExileLeagueBuilder;
import poeapi.model.PathOfExileAccount;
import poeapi.model.PathOfExileCharacterInformation;
import poeapi.model.PathOfExileLeague;
import poeapi.model.PathOfExileTab;
import poeapi.model.PathOfExileTabInformation;
import poetest.PoeTest;

public class TestPathOfExileAccountBuilder {

	private CharacterListHttpDispatcher _characterListDispatcher;
	private PathOfExileLeagueBuilder _leagueBuilder;
	private PathOfExileAccountBuilder _patient;
	
	@Before
	public void setUp() throws Exception {
		_characterListDispatcher = mock(CharacterListHttpDispatcher.class);
		_leagueBuilder = mock(PathOfExileLeagueBuilder.class);
		
		_patient = new PathOfExileAccountBuilder(_characterListDispatcher, _leagueBuilder);
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
		
		_leagueBuilder = null;
		_characterListDispatcher = null;
	}

	@Test
	public void testWillGetAllCharactersFromAccount() {
		String sessionId = new String("sessionId");
		
		_patient.buildAccount(null, sessionId);
		
		verify(_characterListDispatcher).characters(sessionId);
	}
	@Test
	public void testWillGetAllLeaguesFromAccount() {
		String accountName = new String("accountName");
		String sessionId = new String("sessionId");
		List<PathOfExileCharacterInformation> characterInformation = 
				new ArrayList<PathOfExileCharacterInformation>();
		when(_characterListDispatcher.characters(sessionId)).thenReturn(characterInformation);
		
		_patient.buildAccount(accountName, sessionId);
		
		verify(_leagueBuilder).buildLeague(characterInformation, accountName, sessionId);
	}
	@Test
	public void testWillBuildAccountsWithLeagues() {
		String accountName = new String("accountName");
		String sessionId = new String("sessionId");
		PathOfExileTabInformation league1Tab1Information = new PathOfExileTabInformation(); 
		league1Tab1Information.setName("league1Tab1");
		PathOfExileTab league1Tab1 = new PathOfExileTab(league1Tab1Information, null);
		List<PathOfExileTab> league1Tabs = new ArrayList<PathOfExileTab>();
		league1Tabs.add(league1Tab1);
		PathOfExileLeague league1 = new PathOfExileLeague("league1", league1Tabs, null);
		List<PathOfExileLeague> leagues = new ArrayList<PathOfExileLeague>();
		leagues.add(league1);
		PathOfExileAccount expectedAccount = new PathOfExileAccount(leagues, accountName, sessionId);
		when(_leagueBuilder.buildLeague(any(), any(), any())).thenReturn(leagues);
		
		PathOfExileAccount actualAccount = _patient.buildAccount(accountName, sessionId);
		
		PoeTest.verifyEquals(actualAccount, expectedAccount);
	}

}
