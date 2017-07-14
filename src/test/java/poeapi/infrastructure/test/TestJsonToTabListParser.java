package poeapi.infrastructure.test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poeapi.infrastructure.JsonToTabListParser;
import poeapi.model.PathOfExileTabInformation;
import poetest.PoeTest;

public class TestJsonToTabListParser {

	JsonToTabListParser _patient;
	@Before
	public void setUp() throws Exception {
		_patient = new JsonToTabListParser();
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
	}

	@Test
	public void test() {
		String input = 
			"{\"numTabs\":18,\"tabs\":[{\"n\":\"1\",\"i\":0,\"id\":\""
			+ "87928af\",\"type\":\"NormalStash\",\"hidden\":true,\"selected\":false,\"colour\":"
			+ "{\"r\":124,\"g\":84,\"b\":54},\"srcL\":\"https:\\/\\/web.poa40fc8b\\/Stash_TabL.png\","
			+ "\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YToz9e79054\\/Stash_TabC.png\","
			+ "\"srcR\":\"https:\\/\\/web.po41d0535\\/Stash_TabR.png\"},{\"n\":\"$\",\"i\":1,\"id\":\""
			+ "2eec512\",\"type\":"
			+ "\"CurrencyStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":99,\"g\":128,\"b\":0},"
			+ "\"srcL\":\"https:\\/\\/web.poecdn.co47b68d\\/Stash_TabL.png\","
			+ "\"srcC\":\"https:\\/\\/web.poecdn.com\\/gef22\\/Stash_TabC.png\","
			+ "\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOn85e76da6\\/Stash_TabR.png\"}]}";
		PathOfExileTabInformation expectedTab1 = new PathOfExileTabInformation(
				"1", 
				0, 
				"87928af", 
				"NormalStash", 
				true, 
				false, 
				new Color(124, 84, 54), 
				"https://web.poa40fc8b/Stash_TabL.png", 
				"https://web.poecdn.com/gen/image/YToz9e79054/Stash_TabC.png", 
				"https://web.po41d0535/Stash_TabR.png");
		PathOfExileTabInformation expectedTab2 = new PathOfExileTabInformation(
				"$", 
				1, 
				"2eec512", 
				"CurrencyStash", 
				false, 
				false, 
				new Color(99, 128, 0), 
				"https://web.poecdn.co47b68d/Stash_TabL.png", 
				"https://web.poecdn.com/gef22/Stash_TabC.png", 
				"https://web.poecdn.com/gen/image/YTozOn85e76da6/Stash_TabR.png");
		List<PathOfExileTabInformation> expectedTabs = new ArrayList<PathOfExileTabInformation>();
		expectedTabs.add(expectedTab1);
		expectedTabs.add(expectedTab2);

		List<PathOfExileTabInformation> actualTabs = _patient.getTabs(input);
		
		PoeTest.verifyEquals(actualTabs, expectedTabs);
	}

}
