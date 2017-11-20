package poeapi.model;

import java.util.List;

public class PathOfExileApiUrls {
	private String _loginURL = "https://www.pathofexile.com/login";
    private String _accountNameURL = "https://www.pathofexile.com/character-window/get-account-name";
    private String _charactersURL = "https://www.pathofexile.com/character-window/get-characters";
    private String _stashURL = 
    		"https://www.pathofexile.com/character-window/get-stash-items?league=%s&tabs=1&tabIndex=%d&accountName=%s";
    private String _tabsURL = 
    		"https://www.pathofexile.com/character-window/get-stash-items?league=%s&tabs=1&accountName=%s";
    private String _inventoryURL = 
    		"https://www.pathofexile.com/character-window/get-items?character=%s&accountName=%s";
    private String _poeTradeURL = 
    		"http://poe.trade/search";
    private String _poeTradeParameters = 
			"league=%s&" +
			"type=&" +
			"base=&" +
			"name=%s&" +
			"dmg_min=&" + 
			"dmg_max=&" +
			"aps_min=&" +
			"aps_max=&" +
			"crit_min=&" +
			"crit_max=&" +
			"dps_min=&" +
			"dps_max=&" +
			"edps_min=&" + 
			"edps_max=&" +
			"pdps_min=&" +
			"pdps_max=&" +
			"armour_min=&" +
			"armour_max=&" +
			"evasion_min=&" +
			"evasion_max=&" +
			"shield_min=&" +
			"shield_max=&" +
			"block_min=&" +
			"block_max=&" +
			"sockets_min=&" +
			"sockets_max=&" +
			"link_min=%d&" + 
			"link_max=&" +
			"sockets_r=&" +
			"sockets_g=&" +
			"sockets_b=&" +
			"sockets_w=&" +
			"linked_r=&" +
			"linked_g=&" +
			"linked_b=&" +
			"linked_w=&" +
			"rlevel_min=%d&" +
			"rlevel_max=&" +
			"rstr_min=&" +
			"rstr_max=&" +
			"rdex_min=&" +
			"rdex_max=&" +
			"rint_min=&" +
			"rint_max=&" + 
			"%s" +
			"group_type=And&" +
			"group_min=&" +
			"group_max=&" +
			"group_count=1&" +
			"q_min=%d&" + 
			"q_max=&" +
			"level_min=%d&" +
			"level_max=&" +
			"ilvl_min=%d&" +
			"ilvl_max=&" +
			"rarity=&" +
			"seller=&" +
			"thread=&" +
			"identified=%b&" + 
			"corrupted=%b&" +
			"online=x&" +
			"has_buyout=&" +
			"altart=&" +
			"capquality=x&" +
			"buyout_min=&" +
			"buyout_max=&" +
			"buyout_currency=&" +
			"crafted=&" +
			"enchanted=";

    String modString(String modName, int modMinimum){
    	String url = new String("");
		url += "mod_name=%s&";
		url += "mod_min=%d&";
		url += "mod_max=&";
    	return url;
    }
    
    public String poeTradeUrl(){
    	return _poeTradeURL;
    }
    public String poeTradeParameters(
    		PoeTradeSearchParameters parameters){
    	String modString = new String("");
    	for(PathOfExileItemModification mod : parameters.getMods()){
    		modString += modString(mod.getModName(), mod.getModMinimum());
    	}
    	String url = String.format(_poeTradeParameters, 
    		parameters.getLeague(), 
    		parameters.getTypeLine(), 
    		parameters.getLinkCount(), 
    		parameters.getRequiredLevel(), 
    		modString,
    		parameters.getQuality(), 
    		parameters.getExperienceLevel(), 
    		parameters.getItemLevel(),
    		parameters.isIdentified(), 
    		parameters.isCorrupted());
		return url;
    }
    public String loginUrl(){
    	return _loginURL;
    }
    
    public String accountNameUrl(){
    	return _accountNameURL;
    }
    
    public String charactersUrl(){
    	return _charactersURL;
    }

    public String stashUrl(String league, int stashIndex, String accountName){
    	return String.format(_stashURL, league, stashIndex, accountName);
    }
    
    public String tabsUrl(String league, String accountName){
    	return String.format(_tabsURL, league, accountName);
    }
    
    public String inventortyUrl(String accountName, String characterName){
    	return String.format(_inventoryURL, characterName, accountName);
    }
    
}

