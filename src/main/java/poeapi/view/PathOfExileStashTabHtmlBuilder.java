package poeapi.view;

import poeapi.model.PathOfExileTab;

public class PathOfExileStashTabHtmlBuilder {

	PathOfExileItemListHtmlBuilder _itemListHtmlBuilder;
	
	public PathOfExileStashTabHtmlBuilder(PathOfExileItemListHtmlBuilder itemListHtmlBuilder) {
		super();
		_itemListHtmlBuilder = itemListHtmlBuilder;
	}

	public String buildHtml(PathOfExileTab tab){
		String html = new String("");
		html += _itemListHtmlBuilder.buildHtml(tab.getItems());
		return html;
	}
}
