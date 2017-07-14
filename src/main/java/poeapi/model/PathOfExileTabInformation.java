package poeapi.model;

import java.awt.Color;

public class PathOfExileTabInformation {
	private String _name;
	private int _index;
	private String _id;
	private String _type;
	private boolean _hidden;
	private boolean _selected;
	private Color _color;
	private String _leftTabImage;
	private String _centerTabImage;
	private String _rightTabImage;
	
	public PathOfExileTabInformation(){
		
	}
	
	public PathOfExileTabInformation(
			String name, 
			int index, 
			String id, 
			String type, 
			boolean hidden, 
			boolean selected, 
			Color color,
			String leftTabImage, 
			String centerTabImage, 
			String rightTabImage) {
		super();
		_name = name;
		_index = index;
		_id = id;
		_type = type;
		_hidden = hidden;
		_selected = selected;
		_color = color;
		_leftTabImage = leftTabImage;
		_centerTabImage = centerTabImage;
		_rightTabImage = rightTabImage;
	}

	
	public String getName() {
		return _name;
	}


	public void setName(String name) {
		_name = name;
	}


	public int getIndex() {
		return _index;
	}


	public void setIndex(int index) {
		_index = index;
	}


	public String getId() {
		return _id;
	}


	public void setId(String id) {
		_id = id;
	}


	public String getType() {
		return _type;
	}


	public void setType(String type) {
		_type = type;
	}


	public boolean isHidden() {
		return _hidden;
	}


	public void setHidden(boolean hidden) {
		_hidden = hidden;
	}


	public boolean isSelected() {
		return _selected;
	}


	public void setSelected(boolean selected) {
		_selected = selected;
	}


	public Color getColor() {
		return _color;
	}


	public void setColor(Color color) {
		_color = color;
	}


	public String getLeftTabImage() {
		return _leftTabImage;
	}


	public void setLeftTabImage(String leftTabImage) {
		_leftTabImage = leftTabImage;
	}


	public String getCenterTabImage() {
		return _centerTabImage;
	}


	public void setCenterTabImage(String centerTabImage) {
		_centerTabImage = centerTabImage;
	}


	public String getRightTabImage() {
		return _rightTabImage;
	}


	public void setRightTabImage(String rightTabImage) {
		_rightTabImage = rightTabImage;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_centerTabImage == null) ? 0 : _centerTabImage.hashCode());
		result = prime * result + ((_color == null) ? 0 : _color.hashCode());
		result = prime * result + (_hidden ? 1231 : 1237);
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result + _index;
		result = prime * result + ((_leftTabImage == null) ? 0 : _leftTabImage.hashCode());
		result = prime * result + ((_name == null) ? 0 : _name.hashCode());
		result = prime * result + ((_rightTabImage == null) ? 0 : _rightTabImage.hashCode());
		result = prime * result + (_selected ? 1231 : 1237);
		result = prime * result + ((_type == null) ? 0 : _type.hashCode());
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
		PathOfExileTabInformation other = (PathOfExileTabInformation) obj;
		if (_centerTabImage == null) {
			if (other._centerTabImage != null)
				return false;
		} else if (!_centerTabImage.equals(other._centerTabImage))
			return false;
		if (_color == null) {
			if (other._color != null)
				return false;
		} else if (!_color.equals(other._color))
			return false;
		if (_hidden != other._hidden)
			return false;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		if (_index != other._index)
			return false;
		if (_leftTabImage == null) {
			if (other._leftTabImage != null)
				return false;
		} else if (!_leftTabImage.equals(other._leftTabImage))
			return false;
		if (_name == null) {
			if (other._name != null)
				return false;
		} else if (!_name.equals(other._name))
			return false;
		if (_rightTabImage == null) {
			if (other._rightTabImage != null)
				return false;
		} else if (!_rightTabImage.equals(other._rightTabImage))
			return false;
		if (_selected != other._selected)
			return false;
		if (_type == null) {
			if (other._type != null)
				return false;
		} else if (!_type.equals(other._type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PathOfExileTab [_name=" + _name + ", _index=" + _index + ", _id=" + _id + ", _type=" + _type
				+ ", _hidden=" + _hidden + ", _selected=" + _selected + ", _color=" + _color + ", _leftTabImage="
				+ _leftTabImage + ", _centerTabImage=" + _centerTabImage + ", _rightTabImage=" + _rightTabImage
				+ "]";
	}

	
}
