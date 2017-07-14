package poeapi.infrastructure.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poeapi.infrastructure.PathOfExileLeagueNameParser;
import poeapi.model.PathOfExileCharacterInformation;
import poetest.PoeTest;

public class TestPathOfExileLeagueNameParser {

	PathOfExileLeagueNameParser _patient;
	@Before
	public void setUp() throws Exception {
		_patient = new PathOfExileLeagueNameParser();
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
	}

	@Test
	public void testWillParseLeagueNamesFromCharacterList() {
		List<PathOfExileCharacterInformation> characters = new ArrayList<PathOfExileCharacterInformation>();
		Set<String> expectedLeagueNames = new HashSet<String>();
		PathOfExileCharacterInformation character1 = new PathOfExileCharacterInformation(null, "Legacy", 0, 0, null, 0);
		PathOfExileCharacterInformation character2 = new PathOfExileCharacterInformation(null, "Standard", 0, 0, null, 0);
		characters.add(character1);
		characters.add(character2);
		expectedLeagueNames.add(character1.getLeague());
		expectedLeagueNames.add(character2.getLeague());
		
		Set<String> actualLeagueNames = _patient.parseLeagues(characters);
		
		PoeTest.verifyEquals(actualLeagueNames, expectedLeagueNames);
	}

}
