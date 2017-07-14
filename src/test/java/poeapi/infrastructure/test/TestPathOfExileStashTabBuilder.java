package poeapi.infrastructure.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import poeapi.infrastructure.PathOfExileStashTabBuilder;
import poeapi.infrastructure.PathOfExileStashTabListBuilder;
import poeapi.infrastructure.StashTabHttpDispatcher;
import poeapi.model.PathOfExileTab;
import poeapi.model.PathOfExileTabInformation;
import poetest.PoeTest;

public class TestPathOfExileStashTabBuilder {

	private StashTabHttpDispatcher _characterItemsDispatcher;
	private PathOfExileStashTabListBuilder _stashTabListBuilder;
	private PathOfExileStashTabBuilder _patient;
	
	@Before
	public void setUp() throws Exception {
		_characterItemsDispatcher = mock(StashTabHttpDispatcher.class);
		_stashTabListBuilder = mock(PathOfExileStashTabListBuilder.class);
		_patient = new PathOfExileStashTabBuilder(_characterItemsDispatcher, _stashTabListBuilder);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWillGetTabsInformation() {
		String accountName = new String("accountName");
		String sessionId = new String("sessionId");
		String leagueName = new String("leagueName");
		
		_patient.getStashTabs(accountName, sessionId, leagueName);
		
		verify(_characterItemsDispatcher).getTabs(leagueName, accountName, sessionId);
	}
	@Test
	public void testWillGetStashTabsUsingTabInformation(){
		String accountName = new String("accountName");
		String sessionId = new String("sessionId");
		String leagueName = new String("leagueName");
		List<PathOfExileTabInformation> tabInformation = new ArrayList<PathOfExileTabInformation>();
		PathOfExileTabInformation tabInfo1 = new PathOfExileTabInformation();
		tabInfo1.setName("tab1");
		PathOfExileTabInformation tabInfo2 = new PathOfExileTabInformation();
		tabInfo2.setName("tab2");
		when(_characterItemsDispatcher.getTabs(leagueName, accountName, sessionId)).thenReturn(tabInformation);
		
		_patient.getStashTabs(accountName, sessionId, leagueName);
		
		verify(_stashTabListBuilder).getStashTabs(accountName, sessionId, leagueName, tabInformation);
	}
	@Test
	public void testWillForwardBuiltTabs(){
		String accountName = new String("accountName");
		String sessionId = new String("sessionId");
		String leagueName = new String("leagueName");
		List<PathOfExileTab> expectedTabs = new ArrayList<PathOfExileTab>();
		PathOfExileTabInformation tabInfo1 = new PathOfExileTabInformation();
		PathOfExileTab tab1 = new PathOfExileTab(tabInfo1, null);
		tabInfo1.setName("tab1");
		PathOfExileTabInformation tabInfo2 = new PathOfExileTabInformation();
		PathOfExileTab tab2 = new PathOfExileTab(tabInfo2, null);
		tabInfo2.setName("tab2");
		expectedTabs.add(tab1);
		expectedTabs.add(tab2);
		when(_stashTabListBuilder.getStashTabs(any(), any(), any(), any())).thenReturn(expectedTabs);
		
		List<PathOfExileTab> actualTabs = _patient.getStashTabs(accountName, sessionId, leagueName);

		PoeTest.verifyEquals(actualTabs, expectedTabs);
	}
	

}
