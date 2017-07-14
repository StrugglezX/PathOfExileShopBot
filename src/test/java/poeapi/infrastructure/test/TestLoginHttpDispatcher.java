package poeapi.infrastructure.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poeapi.infrastructure.LoginHttpDispatcher;
import poeapi.infrastructure.PathOfExileHttpCookieDispatcher;
import poeapi.model.PathOfExileApiUrls;
import poetest.PoeTest;

public class TestLoginHttpDispatcher {

	PathOfExileApiUrls _urls;
	PathOfExileHttpCookieDispatcher _httpDispatcher;
	LoginHttpDispatcher _patient;
	@Before
	public void setUp() throws Exception {
		_urls = mock(PathOfExileApiUrls.class);
		_httpDispatcher = mock(PathOfExileHttpCookieDispatcher.class);
		_patient = new LoginHttpDispatcher(_urls, _httpDispatcher);
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
		_httpDispatcher = null;
		_urls = null;
	}


	@Test
	public void loggingIntoPathOfExileWillPostHttpWithCookie() throws Exception {
		String loginUrl = new String("LoginUrlString");
		String sessionId = new String("sessionId");
		String httpPostResponse = new String("The Response something without the input");
		when(_urls.loginUrl()).thenReturn(loginUrl);
		when(_httpDispatcher.getHtmlWithCookie(loginUrl, sessionId)).thenReturn(httpPostResponse);
		
		_patient.loginToPathOfExile(sessionId);
		
		verify(_httpDispatcher).getHtmlWithCookie(loginUrl, sessionId);
	}
	
	@Test
	public void loginWillReturnTrueWhenLoginScreenDoesNotShowsOnPathOfExile() throws Exception {
		String loginUrl = new String("LoginUrlString");
		String sessionId = new String("sessionId");
		String httpPostResponse = new String("The Response something without the input");
		when(_urls.loginUrl()).thenReturn(loginUrl);
		when(_httpDispatcher.getHtmlWithCookie(loginUrl, sessionId)).thenReturn(httpPostResponse);
		
		boolean result = _patient.loginToPathOfExile(sessionId);
		
		PoeTest.verifyTrue(result);
	}
	
	@Test
	public void loginWillReturnFalseWhenLoginScreenShowsOnPathOfExile() throws Exception {
		String loginUrl = new String("LoginUrlString");
		String sessionId = new String("sessionId");
		String httpPostResponse = new String(
				"The Response something <input type=\"text\" name=\"login_email\" id=\"login_email\" value=\"\" class=\"textInput\">");
		when(_urls.loginUrl()).thenReturn(loginUrl);
		when(_httpDispatcher.getHtmlWithCookie(loginUrl, sessionId)).thenReturn(httpPostResponse);
		
		boolean result = _patient.loginToPathOfExile(sessionId);
		
		PoeTest.verifyFalse(result);
	}


}
