package poeapi.infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import poeapi.presentation.LoginServlet;

public class PoeTradeHtmlBodyParser {
	static final Logger LOGGER = LogManager.getLogger(LoginServlet.class);
	public String parseHtmlForAveragePrice(String html){
		LOGGER.warn(html);
		String averagePrice = new String("Fail");
		Document doc = Jsoup.parse(html);
		Elements itemBodies = doc.select("tbody");
		for(Element itemBody : itemBodies){
			String price = itemBody.attr("data-buyout");
			System.out.println("'" + price + "'");
		}
		return averagePrice;
	}
}
