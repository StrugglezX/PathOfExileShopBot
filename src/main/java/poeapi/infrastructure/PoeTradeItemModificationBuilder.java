package poeapi.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import poeapi.model.PathOfExileItem;
import poeapi.model.PathOfExileItemModification;

public class PoeTradeItemModificationBuilder {

	static Pattern numberRegex = Pattern.compile("[0-9]+");
	
	public List<PathOfExileItemModification> buildModifications(PathOfExileItem item){
		List<PathOfExileItemModification> mods = new ArrayList<PathOfExileItemModification>();
		
		for(String explicitMod : item.getExplicitMods()){
			String escapedExplicitMod = explicitMod.replaceAll("[0-9]+", "#");
			int modMinimum = getModNumber(explicitMod);
			PathOfExileItemModification mod = 
					new PathOfExileItemModification(escapedExplicitMod, modMinimum);
			mods.add(mod);
		}
		
		for(String implicitMod : item.getImplicitMods()){
			String escapedImplicitMod = implicitMod.replaceAll("[0-9]+", "#");
			escapedImplicitMod = "(implicit) " + escapedImplicitMod;
			int modMinimum = getModNumber(implicitMod);
			PathOfExileItemModification mod = 
					new PathOfExileItemModification(escapedImplicitMod, modMinimum);
			mods.add(mod);
		}
		
		return mods;
	}
	private int getModNumber(String mod){
		int numbersFound = 0;
		int numberTotal = 0;
		
		Matcher matcher = numberRegex.matcher(mod);
		while(matcher.find()) {
			numberTotal += Integer.parseInt(matcher.group());
			numbersFound++;
		}
		int modMinimum = 0;
		if(numbersFound > 0){
			modMinimum = numberTotal / numbersFound;
		}
		return modMinimum;
	}
}
//mod_name:#% additional Block Chance
//mod_name:+#% to Fire and Cold Resistances
//mod_name:(implicit) #% chance of Projectiles Piercing
//mod_name:(enchant) #% increased Bladefall Area of Effect
//mod_name:(crafted) +# to Weapon range
