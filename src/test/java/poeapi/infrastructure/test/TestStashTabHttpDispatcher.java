package poeapi.infrastructure.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poeapi.infrastructure.StashTabHttpDispatcher;
import poeapi.infrastructure.JsonItemArrayToItemListParser;
import poeapi.infrastructure.JsonToTabListParser;
import poeapi.infrastructure.PathOfExileHttpCookieDispatcher;
import poeapi.model.PathOfExileApiUrls;
import poeapi.model.PathOfExileItem;
import poeapi.model.PathOfExileTabInformation;
import poetest.PoeTest;

public class TestStashTabHttpDispatcher {

	PathOfExileApiUrls _urls;
	PathOfExileHttpCookieDispatcher _httpDispatcher;
	JsonToTabListParser _tabListJsonParser;
	JsonItemArrayToItemListParser _tabItemListParser;
	StashTabHttpDispatcher _patient;
	
	@Before
	public void setUp() throws Exception {
		_urls = mock(PathOfExileApiUrls.class);
		_httpDispatcher = mock(PathOfExileHttpCookieDispatcher.class);
		_tabListJsonParser = mock(JsonToTabListParser.class);
		_tabItemListParser = mock(JsonItemArrayToItemListParser.class);
		_patient = new StashTabHttpDispatcher(_urls, _httpDispatcher, _tabListJsonParser, _tabItemListParser);
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
		_tabItemListParser = null;
		_tabListJsonParser = null;
		_httpDispatcher = null;
		_urls = null;
	}

	@Test
	public void testGetTabsWillGetTabsUrlPage() {
		String league = new String("league");
		String accountName = new String("account");
		String tabsUrl = new String("tabsUrl");
		String sessionId = new String("my id");
		when(_urls.tabsUrl(league, accountName)).thenReturn(tabsUrl);
		
		_patient.getTabs(league, accountName, sessionId);
		
		verify(_httpDispatcher).getHtmlWithCookie(tabsUrl, sessionId);
	}
	@Test
	public void testGetTabsWillParseTabsPageResponse() {
		String league = new String("league");
		String accountName = new String("account");
		String sessionId = new String("my id");
		String httpPostResponse = new String("my response");
		when(_httpDispatcher.getHtmlWithCookie(any(), any())).thenReturn(httpPostResponse);

		_patient.getTabs(league, accountName, sessionId);
		
		verify(_tabListJsonParser).getTabs(httpPostResponse);
	}
	@Test
	public void testGetTabsWillForwardParsedResults() {
		String league = new String("league");
		String accountName = new String("account");
		String sessionId = new String("my id");
		List<PathOfExileTabInformation> expectedTabs = new ArrayList<PathOfExileTabInformation>();
		expectedTabs.add(new PathOfExileTabInformation("n", 1, "id", "t", true, true, new Color(2), "l", "c", "r"));
		when(_tabListJsonParser.getTabs(any())).thenReturn(expectedTabs);
		
		List<PathOfExileTabInformation> actualTabs = _patient.getTabs(league, accountName, sessionId);
		
		PoeTest.verifyEquals(actualTabs, expectedTabs);
	}


	@Test
	public void testItemsFromStashTabWillGetStashUrlPage() {
		String league = new String("league");
		String accountName = new String("account");
		String stashUrl = new String("stashUrl");
		String sessionId = new String("my id");
		int tabIndex = 2;
		when(_urls.stashUrl(league, tabIndex, accountName)).thenReturn(stashUrl);
		
		_patient.getItemsFromStashTab(league, accountName, tabIndex, sessionId);
		
		verify(_httpDispatcher).getHtmlWithCookie(stashUrl, sessionId);
	}
	@Test
	public void testItemsFromStashTabWillParseTabsPageResponse() {
		String league = new String("league");
		String accountName = new String("account");
		String sessionId = new String("my id");
		int tabIndex = 2;
		String httpPostResponse = new String("my response");
		when(_httpDispatcher.getHtmlWithCookie(any(), any())).thenReturn(httpPostResponse);

		_patient.getItemsFromStashTab(league, accountName, tabIndex, sessionId);
		
		verify(_tabItemListParser).getItemsFromJsonItemList(httpPostResponse);
	}
	
//	@Test
//	public void testItemsFromStashTabWillForwardParsedResults() {
//		String league = new String("league");
//		String accountName = new String("account");
//		String sessionId = new String("my id");
//		int tabIndex = 2;
//		List<PathOfExileItem> expectedItems= new ArrayList<PathOfExileItem>();
//		expectedItems.add(new PathOfExileItem(0, 0, 0, null, null, null, null, false, false, null, null, 0, 0, null));
//		when(_tabItemListParser.getItemsFromJsonItemList(any())).thenReturn(expectedItems);
//		
//		List<PathOfExileItem> actualItems = _patient.getItemsFromStashTab(league, accountName, tabIndex, sessionId);
//		
//		PoeTest.verifyEquals(actualItems, expectedItems);
//	}

}
