package poeapi.infrastructure;

import java.util.ArrayList;
import java.util.List;

public class PoeTradeItemPriceCalculator {

	List<String> _listedPrices;
	
	public PoeTradeItemPriceCalculator(){
		_listedPrices = new ArrayList<String>();
	}
	public void addListedPrice(String price){
		_listedPrices.add(price);
	}
	
	public String price(){
		if(_listedPrices.size() == 0){
			return "Fail";
		}
		return _listedPrices.get(0);
	}
}
