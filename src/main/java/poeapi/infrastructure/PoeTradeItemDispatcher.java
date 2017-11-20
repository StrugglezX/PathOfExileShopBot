package poeapi.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import poeapi.infrastructure.PoeTradeSearchParametersBuilder;
import poeapi.model.PathOfExileApiUrls;
import poeapi.model.PathOfExileItem;
import poeapi.model.PoeTradeSearchParameters;
import poeapi.presentation.LoginServlet;

public class PoeTradeItemDispatcher {
	static final Logger LOGGER = LogManager.getLogger(LoginServlet.class);

	PathOfExileApiUrls _urls;
	HttpPostExecutor _httpPostExecutor;
	PoeTradeHtmlBodyParser _poeTradeHtmlBodyParser;
	PoeTradeSearchParametersBuilder _poeTradeParametersBuilder;
	
	public PoeTradeItemDispatcher(
			PathOfExileApiUrls urls, 
			HttpPostExecutor httpPostExecutor, 
			PoeTradeHtmlBodyParser poeTradeHtmlBodyParser,
			PoeTradeSearchParametersBuilder poeTradeParametersBuilder) {
		super();
		_urls = urls;
		_httpPostExecutor = httpPostExecutor;
		_poeTradeHtmlBodyParser = poeTradeHtmlBodyParser;
		_poeTradeParametersBuilder = poeTradeParametersBuilder;
	}

	private PathOfExileItem dummyItem(){
		int width6 = 2;
		int height6 = 3;
		int itemLevel6 = 77;
		String icon6 = "https://web.poecdn.com/image/Art/2DItems/Armours/BodyArmours/VisMortis.png?scale=1&w=2&h=3&v=d9655cd289589716bb4560bbcc5da0e33";
		boolean sixLink6 = true;
		String name6 = "<<set:MS>><<set:M>><<set:S>>Vis Mortis";
		String typeLine6 = "Necromancer Silks";
		boolean corrupted6 = false;
		boolean identified6 = true;
		List<String> implicitMods6 = new ArrayList<String>();
		List<String> explicitMods6 = new ArrayList<String>();
		explicitMods6.add(new String("+20 to maximum Mana"));
		explicitMods6.add(new String("203% increased Energy Shield"));
		explicitMods6.add(new String("Minions have 20% reduced maximum Life"));
		explicitMods6.add(new String("Minions deal 15% increased Damage"));
		explicitMods6.add(new String("+1 to maximum number of Spectres"));
		explicitMods6.add(new String("Minions gain Unholy Might for 10 seconds on Kill"));
		int xLocation6 = 0;
		int yLocation6 = 0;
		List<PathOfExileItem> socketedItems6 = new ArrayList<PathOfExileItem>();
		PathOfExileItem item = new PathOfExileItem(
				width6,
				height6,
				itemLevel6,
				icon6,
				sixLink6,
				name6,
				typeLine6,
				corrupted6,
				identified6,
				implicitMods6,
				explicitMods6,
				xLocation6,
				yLocation6,
				socketedItems6
				); 
		return item;
	}
	public String searchForItem(PathOfExileItem i/*item*/){
		PathOfExileItem item = dummyItem();
		PoeTradeSearchParameters parameters = _poeTradeParametersBuilder.buildParameters(item);
		String parametersString = _urls.poeTradeParameters(
				parameters);
		LOGGER.warn(parameters.toString());
		LOGGER.warn(parametersString);

		String response = new String("No response");
		try {
			response = _httpPostExecutor.postHtml(_urls.poeTradeUrl(), parametersString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		_poeTradeHtmlBodyParser.parseHtmlForAveragePrice(response);
		return response;
	}
}
