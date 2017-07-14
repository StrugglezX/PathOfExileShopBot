package poeapi.infrastructure.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poeapi.infrastructure.JsonToCharacterListParser;
import poeapi.model.PathOfExileCharacterInformation;
import poetest.PoeTest;

public class TestJsonToCharacterListParser {

	JsonToCharacterListParser _patient;
	@Before
	public void setUp() throws Exception {
		_patient = new JsonToCharacterListParser();
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
	}

	@Test
	public void testCanParseTheListOfCharacters() {
		String input = 
			"[{\"name\":\"KristopherSelfyDuel\",\"league\":\"SSF Legacy\",\"classId\":4,\"ascendancyClass\":0,\"class\":\"Duelist\",\"level\":18},"
			+ "{\"name\":\"KristopherRauder\",\"league\":\"Legacy\",\"classId\":1,\"ascendancyClass\":3,\"class\":\"Chieftain\",\"level\":91},"
			+ "{\"name\":\"KristopherRange\",\"league\":\"Standard\",\"classId\":2,\"ascendancyClass\":1,\"class\":\"Raider\",\"level\":85}]";

		PathOfExileCharacterInformation expectedCharacter1 = new PathOfExileCharacterInformation(
				"KristopherSelfyDuel", "SSF Legacy", 4, 0, "Duelist", 18);
		PathOfExileCharacterInformation expectedCharacter2 = new PathOfExileCharacterInformation(
				"KristopherRauder", "Legacy", 1, 3, "Chieftain", 91);
		PathOfExileCharacterInformation expectedCharacter3 = new PathOfExileCharacterInformation(
				"KristopherRange", "Standard", 2, 1, "Raider", 85);
		List<PathOfExileCharacterInformation> expectedCharacters = new ArrayList<PathOfExileCharacterInformation>();
		expectedCharacters.add(expectedCharacter1);
		expectedCharacters.add(expectedCharacter2);
		expectedCharacters.add(expectedCharacter3);
		
		List<PathOfExileCharacterInformation> actualCharacters = _patient.characters(input);
		
		PoeTest.verifyEquals(actualCharacters, expectedCharacters);
	}

}
