package poeapi.view;

import poeapi.model.PathOfExileCharacter;

public class PathOfExileCharacterHtmlBuilder {

	PathOfExileItemListHtmlBuilder _itemListHtmlBuilder;
	
	public PathOfExileCharacterHtmlBuilder(PathOfExileItemListHtmlBuilder itemListHtmlBuilder) {
		super();
		_itemListHtmlBuilder = itemListHtmlBuilder;
	}

	public String buildHtml(PathOfExileCharacter character){
		String html = new String("");
		html += _itemListHtmlBuilder.buildHtml(character.getItems());
		return html;
	}
}
