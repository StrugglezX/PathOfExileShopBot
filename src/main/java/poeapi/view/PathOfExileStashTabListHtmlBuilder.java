package poeapi.view;

import java.util.List;

import poeapi.model.PathOfExileTab;

public class PathOfExileStashTabListHtmlBuilder {

	PathOfExileStashTabHtmlBuilder _tabHtmlBuilder;
	
	public PathOfExileStashTabListHtmlBuilder(PathOfExileStashTabHtmlBuilder tabHtmlBuilder) {
		super();
		_tabHtmlBuilder = tabHtmlBuilder;
	}

	public String buildHtml(List<PathOfExileTab> stashTabs){
		String html = new String("");
		html += "<div class=\"stashTabs\">\n";
		for(PathOfExileTab tab : stashTabs){
			html += " <button class=\"stashTabButton\" onclick=\"openStashTab(event,";
			html += "'" + tab.getInformation().getName() + "')\">" + tab.getInformation().getName() + "</button>\n";
		}
		html += "</div>\n";

		html += "<div class=\"stashTabs\">\n";
		for(PathOfExileTab tab : stashTabs){
			html += "<div id=\"" + tab.getInformation().getName() + "\" class=\"stashTabContent\">\n";
			html += _tabHtmlBuilder.buildHtml(tab);
			html += "</div>\n";
		}
		html += "</div>\n";
		return html;
	}
}
