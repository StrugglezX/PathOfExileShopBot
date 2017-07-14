package poeapi.infrastructure.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

import poeapi.infrastructure.PathOfExileLeagueBuilder;
import poeapi.infrastructure.PathOfExileLeagueCharacterBuilder;
import poeapi.infrastructure.PathOfExileLeagueNameParser;
import poeapi.infrastructure.PathOfExileStashTabBuilder;
import poeapi.model.PathOfExileCharacter;
import poeapi.model.PathOfExileCharacterInformation;
import poeapi.model.PathOfExileLeague;
import poeapi.model.PathOfExileTab;
import poeapi.model.PathOfExileTabInformation;
import poetest.PoeTest;

public class TestPathOfExileLeagueBuilder {

	private PathOfExileLeagueNameParser _leagueParser;
	private PathOfExileStashTabBuilder _stashTabBuilder;
	private PathOfExileLeagueCharacterBuilder _leagueCharacterBuilder;
	private PathOfExileLeagueBuilder _patient;
	
	@Before
	public void setUp() throws Exception {
		_leagueParser = mock(PathOfExileLeagueNameParser.class);
		_stashTabBuilder = mock(PathOfExileStashTabBuilder.class);
		_leagueCharacterBuilder = mock(PathOfExileLeagueCharacterBuilder.class);
		
		_patient = new PathOfExileLeagueBuilder(_leagueParser, _stashTabBuilder, _leagueCharacterBuilder);
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
		
		_leagueCharacterBuilder = null;
		_stashTabBuilder = null;
		_leagueParser = null;
	}

	@Test
	public void testWillParseAllCharactersForLeagues() {
		List<PathOfExileCharacterInformation> characterInfo = new ArrayList<PathOfExileCharacterInformation>();
		PathOfExileCharacterInformation characterInfo1 = new PathOfExileCharacterInformation();
		characterInfo1.setName("characterInfo1");
		characterInfo.add(characterInfo1);
		PathOfExileCharacterInformation characterInfo2 = new PathOfExileCharacterInformation();
		characterInfo2.setName("characterInfo2");
		characterInfo.add(characterInfo2);
		String accountName = new String("accountName"); 
		String sessionId = new String("sessionId");
		
		_patient.buildLeague(characterInfo, accountName, sessionId);
		
		verify(_leagueParser).parseLeagues(characterInfo);
	}

	@Test 
	public void testWillGetStashTabsFromEveryLeague(){
		String accountName = new String("accountName"); 
		String sessionId = new String("sessionId");
		Set<String> leagueNames = new HashSet<String>();
		String league1 = new String("league1");
		String league2 = new String("league2");
		leagueNames.add(league1);
		leagueNames.add(league2);
		when(_leagueParser.parseLeagues(any())).thenReturn(leagueNames);
		
		_patient.buildLeague(null, accountName, sessionId);

		verify(_stashTabBuilder).getStashTabs(accountName, sessionId, league1);
		verify(_stashTabBuilder).getStashTabs(accountName, sessionId, league2);
	}
	
	@Test 
	public void testWillGetCharactersFromEveryLeague(){
		List<PathOfExileCharacterInformation> characterInfo = new ArrayList<PathOfExileCharacterInformation>();
		PathOfExileCharacterInformation characterInfo1 = new PathOfExileCharacterInformation();
		characterInfo1.setName("characterInfo1");
		characterInfo.add(characterInfo1);
		PathOfExileCharacterInformation characterInfo2 = new PathOfExileCharacterInformation();
		characterInfo2.setName("characterInfo2");
		characterInfo.add(characterInfo2);
		String accountName = new String("accountName"); 
		String sessionId = new String("sessionId");
		Set<String> leagueNames = new HashSet<String>();
		String league1 = new String("league1");
		String league2 = new String("league2");
		leagueNames.add(league1);
		leagueNames.add(league2);
		when(_leagueParser.parseLeagues(any())).thenReturn(leagueNames);
		
		_patient.buildLeague(characterInfo, accountName, sessionId);

		verify(_leagueCharacterBuilder).getLeagueCharacters(characterInfo, accountName, sessionId, league1);
		verify(_leagueCharacterBuilder).getLeagueCharacters(characterInfo, accountName, sessionId, league2);
	}
	@Test 
	public void testWillCreateLeaguesWithAllStashTabsAndCharacters(){
		List<PathOfExileLeague> expectedLeagues = new ArrayList<PathOfExileLeague>();
		List<PathOfExileTab> stashTabs1 = new ArrayList<PathOfExileTab>();
		PathOfExileTab stashTabs1Tab1 = new PathOfExileTab();
		PathOfExileTabInformation stashTabs1Tab1Information = new PathOfExileTabInformation();
		stashTabs1Tab1Information.setName("stashTabs1Tab1Information");
		stashTabs1Tab1.setInformation(stashTabs1Tab1Information);
		stashTabs1.add(stashTabs1Tab1);
		PathOfExileTab stashTabs1Tab2 = new PathOfExileTab();
		PathOfExileTabInformation stashTabs1Tab2Information = new PathOfExileTabInformation();
		stashTabs1Tab1Information.setName("stashTabs1Tab2Information");
		stashTabs1Tab1.setInformation(stashTabs1Tab2Information);
		stashTabs1.add(stashTabs1Tab2);
		List<PathOfExileCharacter> leagueCharacters1 = new ArrayList<PathOfExileCharacter>();
		PathOfExileCharacter leagueCharacters1Character1 = new PathOfExileCharacter();
		PathOfExileCharacterInformation leagueCharacters1Character1Information = new PathOfExileCharacterInformation();
		leagueCharacters1Character1Information.setName("leagueCharacters1Character1Information");
		leagueCharacters1Character1.setInformation(leagueCharacters1Character1Information);
		leagueCharacters1.add(leagueCharacters1Character1);
		PathOfExileCharacter leagueCharacters1Character2 = new PathOfExileCharacter();
		PathOfExileCharacterInformation leagueCharacters1Character2Information = new PathOfExileCharacterInformation();
		leagueCharacters1Character2Information.setName("leagueCharacters1Character2Information");
		leagueCharacters1Character2.setInformation(leagueCharacters1Character2Information);
		leagueCharacters1.add(leagueCharacters1Character2);
		String leagueName1 = new String("leagueName1");
		PathOfExileLeague league1 = new PathOfExileLeague(leagueName1, stashTabs1, leagueCharacters1);
		expectedLeagues.add(league1);
		List<PathOfExileTab> stashTabs2 = new ArrayList<PathOfExileTab>();
		PathOfExileTab stashTabs2Tab1 = new PathOfExileTab();
		PathOfExileTabInformation stashTabs2Tab1Information = new PathOfExileTabInformation();
		stashTabs2Tab1Information.setName("stashTabs2Tab1Information");
		stashTabs2Tab1.setInformation(stashTabs2Tab1Information);
		stashTabs2.add(stashTabs2Tab1);
		PathOfExileTab stashTabs2Tab2 = new PathOfExileTab();
		PathOfExileTabInformation stashTabs2Tab2Information = new PathOfExileTabInformation();
		stashTabs2Tab1Information.setName("stashTabs2Tab2Information");
		stashTabs2Tab1.setInformation(stashTabs2Tab2Information);
		stashTabs2.add(stashTabs2Tab2);
		List<PathOfExileCharacter> leagueCharacters2 = new ArrayList<PathOfExileCharacter>();
		PathOfExileCharacter leagueCharacters2Character1 = new PathOfExileCharacter();
		PathOfExileCharacterInformation leagueCharacters2Character1Information = new PathOfExileCharacterInformation();
		leagueCharacters2Character1Information.setName("leagueCharacters2Character1Information");
		leagueCharacters2Character1.setInformation(leagueCharacters2Character1Information);
		leagueCharacters2.add(leagueCharacters2Character1);
		PathOfExileCharacter leagueCharacters2Character2 = new PathOfExileCharacter();
		PathOfExileCharacterInformation leagueCharacters2Character2Information = new PathOfExileCharacterInformation();
		leagueCharacters2Character2Information.setName("leagueCharacters2Character2Information");
		leagueCharacters2Character2.setInformation(leagueCharacters2Character2Information);
		leagueCharacters2.add(leagueCharacters2Character2);
		String leagueName2 = new String("leagueName2");
		PathOfExileLeague league2 = new PathOfExileLeague(leagueName2, stashTabs2, leagueCharacters2);
		expectedLeagues.add(league2);
		Set<String> leagueNames = new HashSet<String>();
		leagueNames.add(leagueName1);
		leagueNames.add(leagueName2);
		when(_leagueParser.parseLeagues(any())).thenReturn(leagueNames);
		when(_stashTabBuilder.getStashTabs(any(), any(), eq(leagueName1))).thenReturn(stashTabs1);
		when(_stashTabBuilder.getStashTabs(any(), any(), eq(leagueName2))).thenReturn(stashTabs2);
		when(_leagueCharacterBuilder.getLeagueCharacters(any(), any(), any(), eq(leagueName1))).thenReturn(leagueCharacters1);
		when(_leagueCharacterBuilder.getLeagueCharacters(any(), any(), any(), eq(leagueName2))).thenReturn(leagueCharacters2);
		
		List<PathOfExileLeague> actualLeagues = _patient.buildLeague(null, null, null);

		PoeTest.verifyEquals(actualLeagues, expectedLeagues);
	}

}
