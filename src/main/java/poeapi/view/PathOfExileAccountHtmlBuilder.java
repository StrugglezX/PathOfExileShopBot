package poeapi.view;

import poeapi.model.PathOfExileAccount;

public class PathOfExileAccountHtmlBuilder {

	private PathOfExileLeagueListHtmlBuilder _leagueListBuilder;
	
	public PathOfExileAccountHtmlBuilder(PathOfExileLeagueListHtmlBuilder leagueListBuilder) {
		super();
		_leagueListBuilder = leagueListBuilder;
	}

	public String buildHtml(PathOfExileAccount account){
		String html = new String("");
		html += "<h1>" + account.getAccountName(); 
		html += "'s Account : ";
		html += account.getPoeSessId(); 
		html += "</h1>\n";
		html += _leagueListBuilder.buildHtml(account.getLeagues());
		
		return html;
	}
}
