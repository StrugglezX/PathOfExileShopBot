package poeapi.view;

import java.util.List;

import poeapi.model.PathOfExileLeague;

public class PathOfExileLeagueListHtmlBuilder {

	PathOfExileLeagueHtmlBuilder _leagueHtmlBuilder;
	
	public PathOfExileLeagueListHtmlBuilder(PathOfExileLeagueHtmlBuilder leagueHtmlBuilder) {
		super();
		_leagueHtmlBuilder = leagueHtmlBuilder;
	}

	public String buildHtml(List<PathOfExileLeague> leagues){
		String html = new String("");
		html += "<div class=\"leagueTab\">\n";
		for(PathOfExileLeague league : leagues){
			html += " <button class=\"leagueButton\" onclick=\"openLeague(event,";
			html += "'" + league.getLeagueName() + "')\">" + league.getLeagueName() + "</button>\n";
		}
		html += "</div>\n";
		
		for(PathOfExileLeague league : leagues){
			html += "<div id=\"" + league.getLeagueName() + "\" class=\"leagueTabContent\">\n";
			html += _leagueHtmlBuilder.buildHtml(league);
			html += "</div>\n";
		}

		return html;
	}
}
