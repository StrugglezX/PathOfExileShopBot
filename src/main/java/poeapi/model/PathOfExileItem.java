package poeapi.model;

import java.util.List;

public class PathOfExileItem {
	private int _width;
	private int _height;
	private int _itemLevel;
	private String _icon;
	private List<String> _sockets;
	private String _name;
	private String _typeLine;
	private boolean _corrupted;
	private boolean _identified;
	private List<String> _implicitMods;
	private List<String> _explicitMods;
	private int _xLocation;
	private int _yLocation;
	private List<PathOfExileItem> _socketedItems;
	
	
	public PathOfExileItem() {
		super();
	}

	public PathOfExileItem(int width, int height, int itemLevel, String icon, List<String> sockets, String name,
			String typeLine, boolean corrupted, boolean identified, List<String> implicitMods, List<String> explicitMods, 
			int xLocation, int yLocation, List<PathOfExileItem> socketedItems) {
		super();
		_width = width;
		_height = height;
		_itemLevel = itemLevel;
		_icon = icon;
		_sockets = sockets;
		_name = name;
		_typeLine = typeLine;
		_corrupted = corrupted;
		_identified = identified;
		_implicitMods = implicitMods;
		for(int i = 0; i < _implicitMods.size(); i++){
			_implicitMods.set(i, _implicitMods.get(i).replaceAll("\\n", " "));
		}
		_explicitMods = explicitMods;
		for(int i = 0; i < _explicitMods.size(); i++){
			_explicitMods.set(i, _explicitMods.get(i).replaceAll("\\n", " "));
		}
			
		_xLocation = xLocation;
		_yLocation = yLocation;
		_socketedItems = socketedItems;
	}
	

	public int getWidth() {
		return _width;
	}

	public void setWidth(int width) {
		_width = width;
	}

	public int getHeight() {
		return _height;
	}

	public void setHeight(int height) {
		_height = height;
	}

	public int getItemLevel() {
		return _itemLevel;
	}

	public void setItemLevel(int itemLevel) {
		_itemLevel = itemLevel;
	}

	public String getIcon() {
		return _icon;
	}

	public void setIcon(String icon) {
		_icon = icon;
	}

	public List<String> getSockets() {
		return _sockets;
	}

	public void setSockets(List<String> sockets) {
		_sockets = sockets;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTypeLine() {
		return _typeLine;
	}

	public void setTypeLine(String typeLine) {
		_typeLine = typeLine;
	}

	public boolean isCorrupted() {
		return _corrupted;
	}

	public void setCorrupted(boolean corrupted) {
		_corrupted = corrupted;
	}

	public boolean isIdentified() {
		return _identified;
	}

	public void setIdentified(boolean identified) {
		_identified = identified;
	}

	public List<String> getImplicitMods() {
		return _implicitMods;
	}

	public void setImplicitMods(List<String> implicitMods) {
		_implicitMods = implicitMods;
	}

	public List<String> getExplicitMods() {
		return _explicitMods;
	}

	public void setExplicitMods(List<String> explicitMods) {
		_explicitMods = explicitMods;
	}

	public int getxLocation() {
		return _xLocation;
	}

	public void setxLocation(int xLocation) {
		_xLocation = xLocation;
	}

	public int getyLocation() {
		return _yLocation;
	}

	public void setyLocation(int yLocation) {
		_yLocation = yLocation;
	}

	public List<PathOfExileItem> getSocketedItems() {
		return _socketedItems;
	}

	public void setSocketedItems(List<PathOfExileItem> socketedItems) {
		_socketedItems = socketedItems;
	}

	public static int getGlobal_count() {
		return global_count;
	}

	public static void setGlobal_count(int global_count) {
		PathOfExileItem.global_count = global_count;
	}

	@Override
	public String toString() {
		return "PathOfExileItem [_width=" + _width + ", _height=" + _height + ", _itemLevel=" + _itemLevel + ", _icon="
				+ _icon + ", _sockets=" + _sockets + ", _name=" + _name + ", _typeLine=" + _typeLine + ", _corrupted="
				+ _corrupted + ", _identified=" + _identified + ", _implicitMods=" + _implicitMods 
				+ ", _explicitMods=" + _explicitMods + ", _xLocation=" + _xLocation + ", _yLocation=" + _yLocation 
				+ ", _socketedItems=" + _socketedItems + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (_corrupted ? 1231 : 1237);
		result = prime * result + ((_explicitMods == null) ? 0 : _explicitMods.hashCode());
		result = prime * result + _height;
		result = prime * result + ((_icon == null) ? 0 : _icon.hashCode());
		result = prime * result + (_identified ? 1231 : 1237);
		result = prime * result + ((_implicitMods == null) ? 0 : _implicitMods.hashCode());
		result = prime * result + _itemLevel;
		result = prime * result + ((_name == null) ? 0 : _name.hashCode());
		result = prime * result + ((_socketedItems == null) ? 0 : _socketedItems.hashCode());
		result = prime * result + ((_sockets == null) ? 0 : _sockets.hashCode());
		result = prime * result + ((_typeLine == null) ? 0 : _typeLine.hashCode());
		result = prime * result + _width;
		result = prime * result + _xLocation;
		result = prime * result + _yLocation;
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
		PathOfExileItem other = (PathOfExileItem) obj;
		if (_corrupted != other._corrupted)
			return false;
		if (_explicitMods == null) {
			if (other._explicitMods != null)
				return false;
		} else if (!_explicitMods.equals(other._explicitMods))
			return false;
		if (_height != other._height)
			return false;
		if (_icon == null) {
			if (other._icon != null)
				return false;
		} else if (!_icon.equals(other._icon))
			return false;
		if (_identified != other._identified)
			return false;
		if (_implicitMods == null) {
			if (other._implicitMods != null)
				return false;
		} else if (!_implicitMods.equals(other._implicitMods))
			return false;
		if (_itemLevel != other._itemLevel)
			return false;
		if (_name == null) {
			if (other._name != null)
				return false;
		} else if (!_name.equals(other._name))
			return false;
		if (_socketedItems == null) {
			if (other._socketedItems != null)
				return false;
		} else if (!_socketedItems.equals(other._socketedItems))
			return false;
		if (_sockets == null) {
			if (other._sockets != null)
				return false;
		} else if (!_sockets.equals(other._sockets))
			return false;
		if (_typeLine == null) {
			if (other._typeLine != null)
				return false;
		} else if (!_typeLine.equals(other._typeLine))
			return false;
		if (_width != other._width)
			return false;
		if (_xLocation != other._xLocation)
			return false;
		if (_yLocation != other._yLocation)
			return false;
		return true;
	}



	static int global_count = 0;
	public String debugToString(String parentListVariable){
		int count = global_count++;
		StringBuilder constructionString = new StringBuilder();
		constructionString.append(String.format("int width%d = %d;\n", count, getWidth()));
		constructionString.append(String.format("int height%d = %d;\n", count, getHeight()));
		constructionString.append(String.format("int itemLevel%d = %d;\n", count, getItemLevel()));
		constructionString.append(String.format("String icon%d = \"%s\";\n", count, getIcon()));
		constructionString.append(String.format("List<String> sockets%d = new ArrayList<String>();\n", count));
		List<String> sockets = getSockets();
		for(int i = 0; i < sockets.size(); i++){
			constructionString.append(String.format("sockets%d.add(new String(\"%s\"));\n", count, sockets.get(i)));
		}
		constructionString.append(String.format("String name%d = \"%s\";\n", count, getName()));
		constructionString.append(String.format("String typeLine%d = \"%s\";\n", count, getTypeLine()));
		constructionString.append(String.format("boolean corrupted%d = %b;\n", count, isCorrupted()));
		constructionString.append(String.format("boolean identified%d = %b;\n", count, isIdentified()));
		constructionString.append(String.format("List<String> implicitMods%d = new ArrayList<String>();\n", count));
		List<String> implicitMods = getImplicitMods();
		for(int i = 0; i < implicitMods.size(); i++){
			constructionString.append(String.format("implicitMods%d.add(new String(\"%s\"));\n", count, implicitMods.get(i)));
		}
		constructionString.append(String.format("List<String> explicitMods%d = new ArrayList<String>();\n", count));
		List<String> explicitMods = getExplicitMods();
		for(int i = 0; i < explicitMods.size(); i++){
			constructionString.append(String.format("explicitMods%d.add(new String(\"%s\"));\n", count, explicitMods.get(i)));
		}
		constructionString.append(String.format("int xLocation%d = %d;\n", count, getxLocation()));
		constructionString.append(String.format("int yLocation%d = %d;\n", count, getyLocation()));
		constructionString.append(String.format("List<PathOfExileItem> socketedItems%d = new ArrayList<PathOfExileItem>();\n", count));
		List<PathOfExileItem> socketsItems = getSocketedItems();
		for(int i = 0; i < socketsItems.size(); i++){
			constructionString.append(String.format("%s", socketsItems.get(i).debugToString(String.format("socketedItems%d", count))));
		}
		
		
		
		constructionString.append(String.format("PathOfExileItem expectedItem%d = new PathOfExileItem(\n", count));
		constructionString.append(String.format("\twidth%d,\n", count));
		constructionString.append(String.format("\theight%d,\n", count));
		constructionString.append(String.format("\titemLevel%d,\n", count));
		constructionString.append(String.format("\ticon%d,\n", count));
		constructionString.append(String.format("\tsockets%d,\n", count));
		constructionString.append(String.format("\tname%d,\n", count));
		constructionString.append(String.format("\ttypeLine%d,\n", count));
		constructionString.append(String.format("\tcorrupted%d,\n", count));
		constructionString.append(String.format("\tidentified%d,\n", count));
		constructionString.append(String.format("\timplicitMods%d,\n", count));
		constructionString.append(String.format("\texplicitMods%d,\n", count));
		constructionString.append(String.format("\txLocation%d,\n", count));
		constructionString.append(String.format("\tyLocation%d,\n", count));
		constructionString.append(String.format("\tsocketedItems%d\n", count));
		constructionString.append(String.format(");\n", count));
		
		constructionString.append(String.format("%s.add(expectedItem%d);\n", parentListVariable, count));
		return constructionString.toString();
	}
	
}
