package poeapi.infrastructure.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import poeapi.infrastructure.PathOfExileStashTabListBuilder;
import poeapi.infrastructure.PathOfExileTabParser;
import poeapi.model.PathOfExileTab;
import poeapi.model.PathOfExileTabInformation;
import poetest.PoeTest;

public class TestPathOfExileStashTabListBuilder {

	private PathOfExileTabParser _tabParser;
	private PathOfExileStashTabListBuilder _patient;
	
	@Before
	public void setUp() throws Exception {
		_tabParser = mock(PathOfExileTabParser.class);
		_patient = new PathOfExileStashTabListBuilder(_tabParser);
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
		_tabParser = null;
	}

	@Test
	public void testWillGetTabForAllTabInformation() {
		String accountName = new String("accountName");
		String sessionId = new String("sessionId");
		String leagueName = new String("leagueName");
		List<PathOfExileTabInformation> tabs = new ArrayList<PathOfExileTabInformation>();
		PathOfExileTabInformation tab1 = new PathOfExileTabInformation();
		tab1.setName("tab1");
		PathOfExileTabInformation tab2 = new PathOfExileTabInformation();
		tab1.setName("tab2");
		tabs.add(tab1);
		tabs.add(tab2);
		
		_patient.getStashTabs(accountName, sessionId, leagueName, tabs);

		for(PathOfExileTabInformation tabInformation : tabs){
			verify(_tabParser).getTab(accountName, sessionId, leagueName, tabInformation);
		}
	}
	
	@Test
	public void testWillForwardTabsInAList()
	{
		List<PathOfExileTab> expectedTabs = new ArrayList<PathOfExileTab>();
		List<PathOfExileTabInformation> tabInformation= new ArrayList<PathOfExileTabInformation>();
		PathOfExileTabInformation tabInfo1 = new PathOfExileTabInformation();
		tabInfo1.setName("tab1");
		PathOfExileTabInformation tabInfo2 = new PathOfExileTabInformation();
		tabInfo1.setName("tab2");
		tabInformation.add(tabInfo1);
		tabInformation.add(tabInfo2);
		PathOfExileTab tab1 = new PathOfExileTab(tabInfo1, null);
		PathOfExileTab tab2 = new PathOfExileTab(tabInfo2, null);
		expectedTabs.add(tab1);
		expectedTabs.add(tab2);
		when(_tabParser.getTab(any(), any(), any(), eq(tabInfo1))).thenReturn(tab1);
		when(_tabParser.getTab(any(), any(), any(), eq(tabInfo2))).thenReturn(tab2);
		
		List<PathOfExileTab> actualTabs = _patient.getStashTabs("", "", "", tabInformation);
		
		PoeTest.verifyEquals(actualTabs, expectedTabs);
	}

}
