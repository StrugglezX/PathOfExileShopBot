package poeapi.infrastructure.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poeapi.infrastructure.CharacterInventoryHttpDispatcher;
import poeapi.infrastructure.JsonItemArrayToItemListParser;
import poeapi.infrastructure.PathOfExileHttpCookieDispatcher;
import poeapi.model.PathOfExileApiUrls;
import poeapi.model.PathOfExileItem;
import poetest.PoeTest;

public class TestCharacterInventoryHttpDispatcher {

	PathOfExileApiUrls _urls;
	PathOfExileHttpCookieDispatcher _httpDispatcher;
	JsonItemArrayToItemListParser _itemListParser;
	CharacterInventoryHttpDispatcher _patient;
	@Before
	public void setUp() throws Exception {
		_urls = mock(PathOfExileApiUrls.class);
		_httpDispatcher = mock(PathOfExileHttpCookieDispatcher.class);
		_itemListParser = mock(JsonItemArrayToItemListParser.class);
		_patient = new CharacterInventoryHttpDispatcher(_urls, _httpDispatcher, _itemListParser);
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
		_itemListParser = null;
		_httpDispatcher = null;
		_urls = null;
	}

	@Test
	public void testGetInventoryWillUseInventoryUrlWithSessionId() {
		String inventoryUrl = new String("inventoryUrl");
		String sessionId = new String("my id");
		String accountName = new String("accountName");
		String characterName = new String("characterName");
		when(_urls.inventortyUrl(accountName, characterName)).thenReturn(inventoryUrl);
		
		_patient.getInventory(accountName, sessionId, characterName);
		
		verify(_httpDispatcher).getHtmlWithCookie(inventoryUrl, sessionId);
	}

	@Test
	public void testGetInventoryWillGiveHttpResponseToParser(){
		String httpPostResponse = new String("my response");
		when(_httpDispatcher.getHtmlWithCookie(any(), any())).thenReturn(httpPostResponse);
		
		_patient.getInventory("", "", "");
		
		verify(_itemListParser).getItemsFromJsonItemList(httpPostResponse);
	}
	
	@Test
	public void testGetInventoryWillForwardInventoryFromParser(){
		List<PathOfExileItem> expectedItems= new ArrayList<PathOfExileItem>();
		expectedItems.add(new PathOfExileItem());
		when(_itemListParser.getItemsFromJsonItemList(any())).thenReturn(expectedItems);
		
		List<PathOfExileItem> actualItems= _patient.getInventory("", "", ""); 
		
		PoeTest.verifyEquals(actualItems, expectedItems);
	}
}
