package poeapi.presentation;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import javax.servlet.http.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import poeapi.infrastructure.LoginHttpDispatcher;
import poeapi.infrastructure.PathOfExileHttpCookieDispatcher;
import poeapi.infrastructure.PoeTradeHtmlBodyParser;
import poeapi.infrastructure.PoeTradeItemDispatcher;
import poeapi.infrastructure.PoeTradeItemModificationBuilder;
import poeapi.infrastructure.TimePassageSimulator;
import poeapi.infrastructure.PoeTradeSearchParametersBuilder;
import poeapi.model.PathOfExileApiUrls;
import poeapi.infrastructure.HttpPostExecutor;

@WebServlet(
		name = "LoginServlet",
		urlPatterns = {"/login"}
		)
public class LoginServlet extends HttpServlet {
	static final Logger LOGGER = LogManager.getLogger(LoginServlet.class);
	
	protected PathOfExileApiUrls _urls;
	protected HttpPostExecutor _httpRequester;
	TimePassageSimulator _timeSimulator;
	protected PathOfExileHttpCookieDispatcher _httpWithCookieRequester;
	protected LoginHttpDispatcher _loginDispatcher;
	
	PoeTradeHtmlBodyParser _poeTradeHtmlBodyParser;
	PoeTradeItemModificationBuilder _poeTradeItemModificationBuilder;
	PoeTradeSearchParametersBuilder _poeTradeParametersBuilder;
	PoeTradeItemDispatcher _poeTradeItemDispatcher;
	
	public void init(ServletConfig conf) throws ServletException{
		super.init(conf);
		_urls = new PathOfExileApiUrls();
		_httpRequester = new HttpPostExecutor();
		_timeSimulator = new TimePassageSimulator();
		_httpWithCookieRequester = new PathOfExileHttpCookieDispatcher(_httpRequester, _timeSimulator);
		_loginDispatcher = new LoginHttpDispatcher(_urls, _httpWithCookieRequester);

		_poeTradeHtmlBodyParser = new PoeTradeHtmlBodyParser();
		_poeTradeItemModificationBuilder = new PoeTradeItemModificationBuilder();
		_poeTradeParametersBuilder = new PoeTradeSearchParametersBuilder(_poeTradeItemModificationBuilder);
		_poeTradeItemDispatcher = new PoeTradeItemDispatcher(_urls, _httpRequester, _poeTradeHtmlBodyParser, _poeTradeParametersBuilder);
		_poeTradeItemDispatcher.searchForItem(null);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		String do_this = req.getParameter("do_this");
		if(do_this != null && do_this.equals("login")){
			String sessionId = req.getParameter("POESESSID");
			if(sessionId == null){
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/");
				rd.forward(req, res);
				return;
			}
			boolean success = _loginDispatcher.loginToPathOfExile(sessionId);
			if(success){
				String accountName = req.getParameter("accountName");
				HttpSession session = req.getSession(true);
				session.setAttribute("accountName",  accountName);
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/account");
				rd.forward(req, res);
				return;
			}
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/");
		rd.forward(req, res);
	}
}








