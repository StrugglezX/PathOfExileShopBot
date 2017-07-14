package poeapi.view;

import java.util.List;

import poeapi.model.PathOfExileCharacter;

public class PathOfExileCharacterListHtmlBuilder {

	PathOfExileCharacterHtmlBuilder _characterHtmlBuilder;
	
	public PathOfExileCharacterListHtmlBuilder(PathOfExileCharacterHtmlBuilder characterHtmlBuilder) {
		super();
		_characterHtmlBuilder = characterHtmlBuilder;
	}

	public String buildHtml(List<PathOfExileCharacter> characters){
		String html = new String("");
		html += "<div class=\"characters\">\n";
		for(PathOfExileCharacter character : characters){
			html += " <button class=\"characterButton\" onclick=\"openCharacter(event,";
			html += "'" + character.getInformation().getName() + "')\">" + character.getInformation().getName() + "</button>\n";
		}
		html += "</div>\n";

		html += "<div class=\"charactersTab\">\n";
		for(PathOfExileCharacter character : characters){
			html += "<div id=\"" + character.getInformation().getName() + "\" class=\"characterContent\">\n";
			html += _characterHtmlBuilder.buildHtml(character);
			html += "</div>\n";
		}
		html += "</div>\n";
		return html;
	}
}
