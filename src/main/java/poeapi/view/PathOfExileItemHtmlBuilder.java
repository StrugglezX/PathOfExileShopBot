package poeapi.view;

import poeapi.model.PathOfExileItem;

public class PathOfExileItemHtmlBuilder {

	public String buildHtml(PathOfExileItem item){
		String html = new String("");
		html += String.format("<img src=\"%s\" alt=\"some_text\" style=\"width:%d;height:%d;\">", 
				item.getIcon(), item.getWidth(), item.getHeight());
		return html;
	}
}
