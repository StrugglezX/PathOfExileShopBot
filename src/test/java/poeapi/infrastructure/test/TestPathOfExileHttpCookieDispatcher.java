package poeapi.infrastructure.test;

import static org.mockito.Mockito.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poeapi.infrastructure.HttpPostExecutor;
import poeapi.infrastructure.PathOfExileHttpCookieDispatcher;
import poeapi.infrastructure.TimePassageSimulator;
import poetest.PoeTest;

public class TestPathOfExileHttpCookieDispatcher {

	HttpPostExecutor _httpPostExecutor;
	TimePassageSimulator _timeSimulator;
	PathOfExileHttpCookieDispatcher _patient;
	
	@Before
	public void setUp() throws Exception {
		_httpPostExecutor = mock(HttpPostExecutor.class);
		_timeSimulator = mock(TimePassageSimulator.class);
		_patient = new PathOfExileHttpCookieDispatcher(_httpPostExecutor, _timeSimulator);
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
		_timeSimulator = null;
		_httpPostExecutor = null;
	}

	@Test
	public void testGetHtmlWithCookieWillSetCookie() {
		String url = "Some url";
		String sessionId = "XYZ";
		String sessionIdCookie = String.format("POESESSID=%s; domain=www.pathofexile.com; path=/", sessionId);
		
		_patient.getHtmlWithCookie(url,  sessionId);
		
		verify(_httpPostExecutor).setRequestProperty("Cookie", sessionIdCookie);
	}
	
	@Test
	public void testGetHtmlWithCookieWillGetUrl() throws Exception {
		String url = "Some url";
		String sessionId = "XYZ";
		
		_patient.getHtmlWithCookie(url,  sessionId);

		verify(_httpPostExecutor).getHTML(url);
	}
	@Test
	public void testGetHtmlWithCookieWillForwardReply() throws Exception {
		String url = "Some url";
		String sessionId = "XYZ";
		String expected = "Expected text";
		when(_httpPostExecutor.getHTML(url)).thenReturn(expected);
		
		String result = _patient.getHtmlWithCookie(url,  sessionId);
		
		PoeTest.verifyEquals(result, expected);
	}

	@Test 
	public void testWillNotDdosPathOfExileDotCom(){
		_patient.getHtmlWithCookie("", "");
		
		verify(_timeSimulator).simulateTimePassage(1000);
	}

}
