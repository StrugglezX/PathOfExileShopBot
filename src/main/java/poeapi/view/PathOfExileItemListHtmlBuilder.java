package poeapi.view;

import java.util.List;

import poeapi.model.PathOfExileItem;

public class PathOfExileItemListHtmlBuilder {

	PathOfExileItemHtmlBuilder _itemHtmlBuilder;
	
	public PathOfExileItemListHtmlBuilder(PathOfExileItemHtmlBuilder itemHtmlBuilder) {
		super();
		_itemHtmlBuilder = itemHtmlBuilder;
	}

	public String buildHtml(List<PathOfExileItem> items){
		String html = new String("");
		for(PathOfExileItem item : items){
			html += _itemHtmlBuilder.buildHtml(item);
		}
		return html;
	}
}
