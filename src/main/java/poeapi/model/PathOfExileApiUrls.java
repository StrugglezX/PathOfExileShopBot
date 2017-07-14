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
    		"http://poe.trade?" +
			"league=%s&" +
			"type=%s&" +
			"base=&" +
			"name=&" +
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
			"identified=%d&" + 
			"corrupted=%d&" +
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
    public String poeTradeUrl(
    		String league, 
    		String type, 
    		int linkCount, 
    		int requiredLevel, 
    		List<PathOfExileItemModification> mods, 
    		int quality, 
    		int experienceLevel, 
    		int itemLevel,
    		boolean identified, 
    		boolean corrupted){
    	String modString = new String("");
    	for(PathOfExileItemModification mod : mods){
    		modString += modString(mod.getModName(), mod.getModMinimum());
    	}
    	String url = String.format(_poeTradeURL, 
    		league, 
    		type, 
    		linkCount, 
    		requiredLevel, 
    		modString,
    		quality, 
    		experienceLevel, 
    		itemLevel,
    		identified, 
    		corrupted);
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



/*
league:Legacy
type:Boots
base:Ambush Boots
name:itemName
dmg_min:1
dmg_max:2
aps_min:3
aps_max:4
crit_min:5
crit_max:6
dps_min:7
dps_max:8
edps_min:9
edps_max:10
pdps_min:11
pdps_max:12
armour_min:13
armour_max:14
evasion_min:15
evasion_max:16
shield_min:17
shield_max:18
block_min:19
block_max:20
sockets_min:21
sockets_max:22
link_min:122
link_max:24
sockets_r:25
sockets_g:26
sockets_b:27
sockets_w:28
linked_r:29
linked_g:30
linked_b:31
linked_w:32
rlevel_min:33
rlevel_max:34
rstr_min:35
rstr_max:36
rdex_min:37
rdex_max:38
rint_min:39
rint_max:40
mod_name:(pseudo) (total) +#% to Fire Resistance
mod_min:41
mod_max:42
mod_name:(pseudo) (total) # Life Regenerated per second
mod_min:43
mod_max:44
mod_name=%2B%23%25+to+Fire+Resistance&mod_min=41&mod_max=42&mod_name=%28pseudo%29+%28total%29+%23+Life+Regenerated+per+second&mod_min=43&mod_max=44&mod_name=&mod_min=&mod_max=&
group_type:And
group_min:
group_max:
group_count:2
q_min:43
q_max:44
level_min:45
level_max:46
ilvl_min:47
ilvl_max:48
rarity:relic
seller:sellerNAme
thread:threadNumber
identified:1
corrupted:1
online:
has_buyout:1
altart:x
capquality:
buyout_min:50
buyout_max:51
buyout_currency:chisel
crafted:1
enchanted:0
*/