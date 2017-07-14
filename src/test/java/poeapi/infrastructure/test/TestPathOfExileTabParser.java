package poeapi.infrastructure.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poeapi.infrastructure.PathOfExileTabParser;
import poeapi.infrastructure.StashTabHttpDispatcher;
import poeapi.model.PathOfExileItem;
import poeapi.model.PathOfExileTab;
import poeapi.model.PathOfExileTabInformation;
import poetest.PoeTest;

public class TestPathOfExileTabParser {

	private StashTabHttpDispatcher _characterItemsDispatcher;
	private PathOfExileTabParser _patient;
	@Before
	public void setUp() throws Exception {
		_characterItemsDispatcher = mock(StashTabHttpDispatcher.class);
		_patient = new PathOfExileTabParser(_characterItemsDispatcher);
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
		_characterItemsDispatcher = null;
	}

	@Test
	public void testWillGetItemsFromStash() {
		String accountName = new String("accountName");
		String sessionId = new String("sessionId");
		String leagueName = new String("leagueName");
		PathOfExileTabInformation tabInformation = new PathOfExileTabInformation();
		tabInformation.setIndex(6);
		
		_patient.getTab(accountName, sessionId, leagueName, tabInformation);
		
		verify(_characterItemsDispatcher).getItemsFromStashTab(leagueName, accountName, tabInformation.getIndex(), sessionId);
	}
	
	public void testCreateStashTabsCorrectly(){
		PathOfExileTabInformation tabInformation = new PathOfExileTabInformation();
		tabInformation.setIndex(6);
		List<PathOfExileItem> tabItems = new ArrayList<PathOfExileItem>();
		PathOfExileItem item1 = new PathOfExileItem();
		item1.setName("item1");
		PathOfExileItem item2 = new PathOfExileItem();
		item2.setName("item2");
		tabItems.add(item1);
		tabItems.add(item2);
		PathOfExileTab expectedTab = new PathOfExileTab(tabInformation, tabItems);
		
		PathOfExileTab actualTab = _patient.getTab("", "", "", tabInformation);
		
		PoeTest.verifyEquals(actualTab, expectedTab);
	}

}
