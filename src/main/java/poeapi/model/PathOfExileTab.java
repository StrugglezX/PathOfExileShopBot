package poeapi.model;

import java.util.List;

public class PathOfExileTab {
	private PathOfExileTabInformation _information;
	private List<PathOfExileItem> _items;
	public PathOfExileTab(){
		super();
	}
	public PathOfExileTab(PathOfExileTabInformation information, List<PathOfExileItem> items) {
		super();
		_information = information;
		_items = items;
	}
	
	public PathOfExileTabInformation getInformation() {
		return _information;
	}
	public void setInformation(PathOfExileTabInformation information) {
		_information = information;
	}
	public List<PathOfExileItem> getItems() {
		return _items;
	}
	public void setItems(List<PathOfExileItem> items) {
		_items = items;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_information == null) ? 0 : _information.hashCode());
		result = prime * result + ((_items == null) ? 0 : _items.hashCode());
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
		PathOfExileTab other = (PathOfExileTab) obj;
		if (_information == null) {
			if (other._information != null)
				return false;
		} else if (!_information.equals(other._information))
			return false;
		if (_items == null) {
			if (other._items != null)
				return false;
		} else if (!_items.equals(other._items))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PathOfExileTab [_information=" + _information + ", _items=" + _items + "]";
	}
	
}
