package poeapi.model;

import java.util.List;

public class PoeTradeSearchParameters {
	String _league;
	String _typeLine; 
	int _linkCount;
	int _requiredLevel; 
	List<PathOfExileItemModification> _mods; 
	int _quality;
	int _experienceLevel; 
	int _itemLevel;
	boolean _identified; 
	boolean _corrupted;
	
	public PoeTradeSearchParameters(){
		super();
	}
	
	public PoeTradeSearchParameters(
			String league, 
			String typeLine, 
			int linkCount, 
			int requiredLevel,
			List<PathOfExileItemModification> mods, 
			int quality, 
			int experienceLevel, 
			int itemLevel, 
			boolean identified,
			boolean corrupted) {
		super();
		_league = league;
		_typeLine = typeLine;
		_linkCount = linkCount;
		_requiredLevel = requiredLevel;
		_mods = mods;
		_quality = quality;
		_experienceLevel = experienceLevel;
		_itemLevel = itemLevel;
		_identified = identified;
		_corrupted = corrupted;
	}

	public String getLeague() {
		return _league;
	}

	public void setLeague(String league) {
		_league = league;
	}

	public String getTypeLine() {
		return _typeLine;
	}

	public void setTypeLine(String typeLine) {
		_typeLine = typeLine;
	}

	public int getLinkCount() {
		return _linkCount;
	}

	public void setLinkCount(int linkCount) {
		_linkCount = linkCount;
	}

	public int getRequiredLevel() {
		return _requiredLevel;
	}

	public void setRequiredLevel(int requiredLevel) {
		_requiredLevel = requiredLevel;
	}

	public List<PathOfExileItemModification> getMods() {
		return _mods;
	}

	public void setMods(List<PathOfExileItemModification> mods) {
		_mods = mods;
	}

	public int getQuality() {
		return _quality;
	}

	public void setQuality(int quality) {
		_quality = quality;
	}

	public int getExperienceLevel() {
		return _experienceLevel;
	}

	public void setExperienceLevel(int experienceLevel) {
		_experienceLevel = experienceLevel;
	}

	public int getItemLevel() {
		return _itemLevel;
	}

	public void setItemLevel(int itemLevel) {
		_itemLevel = itemLevel;
	}

	public boolean isIdentified() {
		return _identified;
	}

	public void setIdentified(boolean identified) {
		_identified = identified;
	}

	public boolean isCorrupted() {
		return _corrupted;
	}

	public void setCorrupted(boolean corrupted) {
		_corrupted = corrupted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (_corrupted ? 1231 : 1237);
		result = prime * result + _experienceLevel;
		result = prime * result + (_identified ? 1231 : 1237);
		result = prime * result + _itemLevel;
		result = prime * result + ((_league == null) ? 0 : _league.hashCode());
		result = prime * result + _linkCount;
		result = prime * result + ((_mods == null) ? 0 : _mods.hashCode());
		result = prime * result + _quality;
		result = prime * result + _requiredLevel;
		result = prime * result + ((_typeLine == null) ? 0 : _typeLine.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PoeTradeSearchParameters other = (PoeTradeSearchParameters) obj;
		if (_corrupted != other._corrupted)
			return false;
		if (_experienceLevel != other._experienceLevel)
			return false;
		if (_identified != other._identified)
			return false;
		if (_itemLevel != other._itemLevel)
			return false;
		if (_league == null) {
			if (other._league != null)
				return false;
		} else if (!_league.equals(other._league))
			return false;
		if (_linkCount != other._linkCount)
			return false;
		if (_mods == null) {
			if (other._mods != null)
				return false;
		} else if (!_mods.equals(other._mods))
			return false;
		if (_quality != other._quality)
			return false;
		if (_requiredLevel != other._requiredLevel)
			return false;
		if (_typeLine == null) {
			if (other._typeLine != null)
				return false;
		} else if (!_typeLine.equals(other._typeLine))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PoeTradeSearchParameters [_league=" + _league + ", _typeLine=" + _typeLine + ", _linkCount="
				+ _linkCount + ", _requiredLevel=" + _requiredLevel + ", _mods=" + _mods + ", _quality=" + _quality
				+ ", _experienceLevel=" + _experienceLevel + ", _itemLevel=" + _itemLevel + ", _identified="
				+ _identified + ", _corrupted=" + _corrupted + "]";
	}
	
	
}
