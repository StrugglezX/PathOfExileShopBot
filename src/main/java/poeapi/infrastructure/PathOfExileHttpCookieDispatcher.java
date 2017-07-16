package poeapi.infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathOfExileHttpCookieDispatcher {
	static final Logger LOGGER = LogManager.getLogger(PathOfExileHttpCookieDispatcher.class);
	
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
			LOGGER.debug(String.format("GET %s", url));
			response = _httpPostExecutor.getHTML(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		_timeSimulator.simulateTimePassage(1000);
		return response;
	}
}
