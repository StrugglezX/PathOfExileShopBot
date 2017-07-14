package poeapi.model;

public class PathOfExileItemModification {
	String _modName;
	int _modMinimum;
	public PathOfExileItemModification(String modName, int modMinimum) {
		super();
		_modName = modName;
		_modMinimum = modMinimum;
	}
	public String getModName() {
		return _modName;
	}
	public void setModName(String modName) {
		_modName = modName;
	}
	public int getModMinimum() {
		return _modMinimum;
	}
	public void setModMinimum(int modMinimum) {
		_modMinimum = modMinimum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _modMinimum;
		result = prime * result + ((_modName == null) ? 0 : _modName.hashCode());
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
		PathOfExileItemModification other = (PathOfExileItemModification) obj;
		if (_modMinimum != other._modMinimum)
			return false;
		if (_modName == null) {
			if (other._modName != null)
				return false;
		} else if (!_modName.equals(other._modName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PathOfExileItemModification [_modName=" + _modName + ", _modMinimum=" + _modMinimum + "]";
	}
	
}
