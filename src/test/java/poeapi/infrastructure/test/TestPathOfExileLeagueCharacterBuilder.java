package poeapi.infrastructure.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poeapi.infrastructure.CharacterInventoryHttpDispatcher;
import poeapi.infrastructure.PathOfExileLeagueCharacterBuilder;
import poeapi.model.PathOfExileCharacter;
import poeapi.model.PathOfExileCharacterInformation;
import poeapi.model.PathOfExileItem;
import poetest.PoeTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class TestPathOfExileLeagueCharacterBuilder {

	private CharacterInventoryHttpDispatcher _inventoryParser;
	private PathOfExileLeagueCharacterBuilder _patient;
	
	@Before
	public void setUp() throws Exception {
		_inventoryParser = mock(CharacterInventoryHttpDispatcher.class);
		_patient = new PathOfExileLeagueCharacterBuilder(_inventoryParser);
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
		_inventoryParser = null;
	}

	@Test
	public void testWillGetInventoryOfAllCharactersInLeague() {
		String accountName = new String("accountName");
		String sessionId = new String("sessionId");
		String leagueName = new String("leagueName");
		PathOfExileCharacterInformation characterInfo1 = new PathOfExileCharacterInformation();
		characterInfo1.setName("character1");
		characterInfo1.setLeague(leagueName);
		PathOfExileCharacterInformation characterInfo2 = new PathOfExileCharacterInformation();
		characterInfo2.setName("character2");
		characterInfo2.setLeague(leagueName);
		PathOfExileCharacterInformation characterInfo3 = new PathOfExileCharacterInformation();
		characterInfo3.setName("character3");
		characterInfo3.setLeague(new String("otherLeague"));
		List<PathOfExileCharacterInformation> characterInfoList = new ArrayList<PathOfExileCharacterInformation>();
		characterInfoList.add(characterInfo1);
		characterInfoList.add(characterInfo2);
		characterInfoList.add(characterInfo3);
		
		_patient.getLeagueCharacters(characterInfoList, accountName, sessionId, leagueName);

		verify(_inventoryParser).getInventory(accountName, sessionId, characterInfo1.getName());
		verify(_inventoryParser).getInventory(accountName, sessionId, characterInfo2.getName());
		verify(_inventoryParser, never()).getInventory(accountName, sessionId, characterInfo3.getName());
	}

	@Test
	public void testWillBuildLeagueCharactersCorrectly()
	{
		String accountName = new String("accountName");
		String sessionId = new String("sessionId");
		String leagueName = new String("leagueName");
		PathOfExileCharacterInformation characterInfo1 = new PathOfExileCharacterInformation();
		characterInfo1.setName("character1");
		characterInfo1.setLeague(leagueName);
		PathOfExileCharacterInformation characterInfo2 = new PathOfExileCharacterInformation();
		characterInfo2.setName("character2");
		characterInfo2.setLeague(leagueName);
		PathOfExileCharacterInformation characterInfo3 = new PathOfExileCharacterInformation();
		characterInfo3.setName("character3");
		characterInfo3.setLeague(new String("otherLeague"));
		List<PathOfExileCharacterInformation> characterInfoList = new ArrayList<PathOfExileCharacterInformation>();
		characterInfoList.add(characterInfo1);
		characterInfoList.add(characterInfo2);
		characterInfoList.add(characterInfo3);
		List<PathOfExileItem> character1Items = new ArrayList<PathOfExileItem>();
		PathOfExileItem character1Item1 = new PathOfExileItem();
		PathOfExileItem character1Item2 = new PathOfExileItem();
		character1Items.add(character1Item1);
		character1Items.add(character1Item2);
		List<PathOfExileItem> character2Items = new ArrayList<PathOfExileItem>();
		PathOfExileItem character2Item1 = new PathOfExileItem();
		PathOfExileItem character2Item2 = new PathOfExileItem();
		character2Items.add(character2Item1);
		character2Items.add(character2Item2);
		when(_inventoryParser.getInventory(any(), any(), eq(characterInfo1.getName()))).thenReturn(character1Items);
		when(_inventoryParser.getInventory(any(), any(), eq(characterInfo2.getName()))).thenReturn(character2Items);
		PathOfExileCharacter expectedCharacter1 = new PathOfExileCharacter(characterInfo1, character1Items);
		PathOfExileCharacter expectedCharacter2 = new PathOfExileCharacter(characterInfo2, character2Items);
		List<PathOfExileCharacter> expectedCharacters = new ArrayList<PathOfExileCharacter>();
		expectedCharacters.add(expectedCharacter1);
		expectedCharacters.add(expectedCharacter2);
		
		List<PathOfExileCharacter> actualCharacters =
				_patient.getLeagueCharacters(characterInfoList, accountName, sessionId, leagueName);

		PoeTest.verifyEquals(actualCharacters, expectedCharacters);
	}
}
