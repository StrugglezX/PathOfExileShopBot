package poeapi.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import poeapi.infrastructure.CharacterInventoryHttpDispatcher;
import poeapi.infrastructure.CharacterListHttpDispatcher;
import poeapi.infrastructure.HttpPostExecutor;
import poeapi.infrastructure.JsonItemArrayToItemListParser;
import poeapi.infrastructure.JsonToCharacterListParser;
import poeapi.infrastructure.JsonToTabListParser;
import poeapi.infrastructure.PathOfExileAccountBuilder;
import poeapi.infrastructure.PathOfExileHttpCookieDispatcher;
import poeapi.infrastructure.PathOfExileLeagueBuilder;
import poeapi.infrastructure.PathOfExileLeagueCharacterBuilder;
import poeapi.infrastructure.PathOfExileLeagueNameParser;
import poeapi.infrastructure.PathOfExileStashTabBuilder;
import poeapi.infrastructure.PathOfExileStashTabListBuilder;
import poeapi.infrastructure.PathOfExileTabParser;
import poeapi.infrastructure.StashTabHttpDispatcher;
import poeapi.infrastructure.TimePassageSimulator;
import poeapi.model.PathOfExileAccount;
import poeapi.model.PathOfExileApiUrls;
import poeapi.view.PathOfExileAccountHtmlBuilder;
import poeapi.view.PathOfExileCharacterHtmlBuilder;
import poeapi.view.PathOfExileCharacterListHtmlBuilder;
import poeapi.view.PathOfExileItemHtmlBuilder;
import poeapi.view.PathOfExileItemListHtmlBuilder;
import poeapi.view.PathOfExileLeagueHtmlBuilder;
import poeapi.view.PathOfExileLeagueListHtmlBuilder;
import poeapi.view.PathOfExileStashTabHtmlBuilder;
import poeapi.view.PathOfExileStashTabListHtmlBuilder;


@WebServlet(
		name = "AccountServlet",
		urlPatterns = {"/account"}
		)
public class AccountServlet extends HttpServlet {

	static final Logger LOGGER = LogManager.getLogger(AccountServlet.class);
	
	PathOfExileApiUrls _urls;
	HttpPostExecutor _httpPostExecutor;
	TimePassageSimulator _timeSimulator;
	PathOfExileHttpCookieDispatcher _httpDispatcher;
	JsonToCharacterListParser _characterParser;
	CharacterListHttpDispatcher _characterListDispatcher;
	PathOfExileLeagueNameParser _leagueParser;
	JsonToTabListParser _tabListJsonParser;
	JsonItemArrayToItemListParser _tabItemListParser;
	StashTabHttpDispatcher _characterItemsDispatcher;
	PathOfExileTabParser _tabParser;
	PathOfExileStashTabListBuilder _stashTabListBuilder;
	PathOfExileStashTabBuilder _stashTabBuilder;
	CharacterInventoryHttpDispatcher _inventoryParser;
	PathOfExileLeagueCharacterBuilder _leagueCharacterBuilder;
	PathOfExileLeagueBuilder _leagueBuilder;
	PathOfExileAccountBuilder _accountBuilder;

	PathOfExileItemHtmlBuilder _itemHtmlBuilder;
	PathOfExileItemListHtmlBuilder _itemListHtmlBuilder;
	PathOfExileStashTabHtmlBuilder _tabHtmlBuilder;
	PathOfExileCharacterHtmlBuilder _characterHtmlBuilder;
	PathOfExileStashTabListHtmlBuilder _stashTabListHtmlBuilder;
	PathOfExileCharacterListHtmlBuilder _characterListHtmlBuilder;
	PathOfExileLeagueHtmlBuilder _leagueHtmlBuilder;
	PathOfExileLeagueListHtmlBuilder _leagueListBuilder;
	PathOfExileAccountHtmlBuilder _accountHtmlBuilder;
	
	public void init(ServletConfig conf) throws ServletException{
		super.init(conf);
		_urls = new PathOfExileApiUrls();
		_httpPostExecutor = new HttpPostExecutor();
		_timeSimulator = new TimePassageSimulator();
		_httpDispatcher = new PathOfExileHttpCookieDispatcher(_httpPostExecutor, _timeSimulator);
		_characterParser = new JsonToCharacterListParser();
		_characterListDispatcher = new CharacterListHttpDispatcher(
				_urls, 
				_httpDispatcher,
				_characterParser);
		_leagueParser = new PathOfExileLeagueNameParser();
		_tabListJsonParser = new JsonToTabListParser();
		_tabItemListParser = new JsonItemArrayToItemListParser();
		_characterItemsDispatcher = new StashTabHttpDispatcher(
				_urls,
				_httpDispatcher,
				_tabListJsonParser,
				_tabItemListParser);
		_tabParser = new PathOfExileTabParser(_characterItemsDispatcher);
		_stashTabListBuilder = new PathOfExileStashTabListBuilder(_tabParser);
		_stashTabBuilder = new PathOfExileStashTabBuilder(
				_characterItemsDispatcher,
				_stashTabListBuilder);
		_inventoryParser = new CharacterInventoryHttpDispatcher(
				_urls,
				_httpDispatcher,
				_tabItemListParser);
		_leagueCharacterBuilder = new PathOfExileLeagueCharacterBuilder(_inventoryParser);
		_leagueBuilder = new PathOfExileLeagueBuilder(
				_leagueParser, 
				_stashTabBuilder, 
				_leagueCharacterBuilder);
		_accountBuilder = new PathOfExileAccountBuilder(
				_characterListDispatcher, 
				_leagueBuilder);
		_itemHtmlBuilder = new PathOfExileItemHtmlBuilder();
		_itemListHtmlBuilder = new PathOfExileItemListHtmlBuilder(_itemHtmlBuilder);
		_tabHtmlBuilder = new PathOfExileStashTabHtmlBuilder(_itemListHtmlBuilder);
		_characterHtmlBuilder = new PathOfExileCharacterHtmlBuilder(_itemListHtmlBuilder);
		_stashTabListHtmlBuilder = new PathOfExileStashTabListHtmlBuilder(_tabHtmlBuilder);
		_characterListHtmlBuilder = new PathOfExileCharacterListHtmlBuilder(_characterHtmlBuilder);
		_leagueHtmlBuilder = new PathOfExileLeagueHtmlBuilder(_stashTabListHtmlBuilder, _characterListHtmlBuilder);
		_leagueListBuilder = new PathOfExileLeagueListHtmlBuilder(_leagueHtmlBuilder);
		_accountHtmlBuilder = new PathOfExileAccountHtmlBuilder(_leagueListBuilder);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		LOGGER.info("This logging is working");
		String accountName = req.getParameter("accountName");
		String sessionId = req.getParameter("POESESSID");

		HttpSession session = req.getSession();
		
		PathOfExileAccount account = _accountBuilder.buildAccount(accountName, sessionId);
		
		String htmlBody = _accountHtmlBuilder.buildHtml(account);
		session.setAttribute("htmlBody",  htmlBody);
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/Account.jsp");
		rd.forward(req, res);
	}

}
