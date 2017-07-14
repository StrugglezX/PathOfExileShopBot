package poeapi.infrastructure;

import poeapi.model.PathOfExileApiUrls;

public class LoginHttpDispatcher {

	PathOfExileApiUrls _urls;
	PathOfExileHttpCookieDispatcher _httpDispatcher;
	
	public LoginHttpDispatcher(
			PathOfExileApiUrls urls,
			PathOfExileHttpCookieDispatcher httpDispatcher){
		_urls = urls;
		_httpDispatcher = httpDispatcher;
	}
	public boolean loginToPathOfExile(String sessionId){
		String loginUrl = _urls.loginUrl();
		String response = _httpDispatcher.getHtmlWithCookie(loginUrl, sessionId);
		if(response.contains( //todo find better way to tell if login failed?
				"<input type=\"text\" name=\"login_email\" id=\"login_email\" value=\"\" class=\"textInput\">")){
			return false;
		}
		return true;
	}
}
