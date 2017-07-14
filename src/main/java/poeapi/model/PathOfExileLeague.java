package poeapi.model;

import java.util.List;

public class PathOfExileLeague {

	private String _leagueName;
	private List<PathOfExileTab> _stash;
	private List<PathOfExileCharacter> _characters;
	public PathOfExileLeague() {
		super();
	}
	public PathOfExileLeague(String leagueName, List<PathOfExileTab> stash, List<PathOfExileCharacter> characters) {
		super();
		_leagueName = leagueName;
		_stash = stash;
		_characters = characters;
	}
	public String getLeagueName() {
		return _leagueName;
	}
	public void setLeagueName(String leagueName) {
		_leagueName = leagueName;
	}
	public List<PathOfExileTab> getStash() {
		return _stash;
	}
	public void setStash(List<PathOfExileTab> stash) {
		_stash = stash;
	}
	public List<PathOfExileCharacter> getCharacters() {
		return _characters;
	}
	public void setCharacters(List<PathOfExileCharacter> characters) {
		_characters = characters;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_characters == null) ? 0 : _characters.hashCode());
		result = prime * result + ((_leagueName == null) ? 0 : _leagueName.hashCode());
		result = prime * result + ((_stash == null) ? 0 : _stash.hashCode());
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
		PathOfExileLeague other = (PathOfExileLeague) obj;
		if (_characters == null) {
			if (other._characters != null)
				return false;
		} else if (!_characters.equals(other._characters))
			return false;
		if (_leagueName == null) {
			if (other._leagueName != null)
				return false;
		} else if (!_leagueName.equals(other._leagueName))
			return false;
		if (_stash == null) {
			if (other._stash != null)
				return false;
		} else if (!_stash.equals(other._stash))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PathOfExileLeague [_leagueName=" + _leagueName + ", _stash=" + _stash + ", _characters=" + _characters
				+ "]";
	}
	

	
	
}
