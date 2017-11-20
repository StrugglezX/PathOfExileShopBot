package poeapi.infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathOfExileHttpCookieDispatcher {
	
	HttpPostExecutor _httpPostExecutor;
	TimePassageSimulator _timeSimulator;
	String _sessionIdCookieTemplate;
	public PathOfExileHttpCookieDispatcher(
			HttpPostExecutor httpPostExecutor,
			TimePassageSimulator timeSimulator){
		_httpPostExecutor = httpPostExecutor;
		_timeSimulator = timeSimulator;
		_sessionIdCookieTemplate = new String("POESESSID=%s; domain=www.pathofexile.com; path=/");
	}
	
	public String getHtmlWithCookie(String url, String sessionId){
		String response = new String("No response");
		try {
			String sessionIdCookie = String.format(_sessionIdCookieTemplate, sessionId);
			_httpPostExecutor.setRequestProperty("Cookie", sessionIdCookie);
			response = _httpPostExecutor.getHTML(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		_timeSimulator.simulateTimePassage(1000);
		return response;
	}
}
