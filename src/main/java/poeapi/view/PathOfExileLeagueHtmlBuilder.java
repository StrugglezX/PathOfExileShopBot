package poeapi.view;

import poeapi.model.PathOfExileLeague;

public class PathOfExileLeagueHtmlBuilder {

	PathOfExileStashTabListHtmlBuilder _stashTabHtmlBuilder;
	PathOfExileCharacterListHtmlBuilder _characterListHtmlBuilder;
	
	public PathOfExileLeagueHtmlBuilder(PathOfExileStashTabListHtmlBuilder stashTabHtmlBuilder,
			PathOfExileCharacterListHtmlBuilder characterListHtmlBuilder) {
		super();
		_stashTabHtmlBuilder = stashTabHtmlBuilder;
		_characterListHtmlBuilder = characterListHtmlBuilder;
	}

	public String buildHtml(PathOfExileLeague league){
		String html = new String("");
		html += _stashTabHtmlBuilder.buildHtml(league.getStash());
		html += _characterListHtmlBuilder.buildHtml(league.getCharacters());
		return html;
	}
}
