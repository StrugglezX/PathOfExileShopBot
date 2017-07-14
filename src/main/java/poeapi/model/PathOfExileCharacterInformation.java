package poeapi.model;

public class PathOfExileCharacterInformation {
	public PathOfExileCharacterInformation() {
		super();
	}
	public PathOfExileCharacterInformation(String name, String league, int classId, int ascendancyClass,
			String classSpecificationName, int level) {
		super();
		_name = name;
		_league = league;
		_classId = classId;
		_ascendancyClass = ascendancyClass;
		_classSpecificationName = classSpecificationName;
		_level = level;
	}

	private String _name;
	private String _league;
	private int _classId;
	private int _ascendancyClass;
	private String _classSpecificationName;
	private int _level;

	public String getName() {
		return _name;
	}
	public void setName(String name) {
		_name = name;
	}
	public String getLeague() {
		return _league;
	}
	public void setLeague(String league) {
		_league = league;
	}
	public int getClassId() {
		return _classId;
	}
	public void setClassId(int classId) {
		_classId = classId;
	}
	public int getAscendancyClass() {
		return _ascendancyClass;
	}
	public void setAscendancyClass(int ascendancyClass) {
		_ascendancyClass = ascendancyClass;
	}
	public String getClassSpecificationName() {
		return _classSpecificationName;
	}
	public void setClassSpecificationName(String classSpecificationName) {
		_classSpecificationName = classSpecificationName;
	}
	public int getLevel() {
		return _level;
	}
	public void setLevel(int level) {
		_level = level;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _ascendancyClass;
		result = prime * result + _classId;
		result = prime * result + ((_classSpecificationName == null) ? 0 : _classSpecificationName.hashCode());
		result = prime * result + ((_league == null) ? 0 : _league.hashCode());
		result = prime * result + _level;
		result = prime * result + ((_name == null) ? 0 : _name.hashCode());
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
		PathOfExileCharacterInformation other = (PathOfExileCharacterInformation) obj;
		if (_ascendancyClass != other._ascendancyClass)
			return false;
		if (_classId != other._classId)
			return false;
		if (_classSpecificationName == null) {
			if (other._classSpecificationName != null)
				return false;
		} else if (!_classSpecificationName.equals(other._classSpecificationName))
			return false;
		if (_league == null) {
			if (other._league != null)
				return false;
		} else if (!_league.equals(other._league))
			return false;
		if (_level != other._level)
			return false;
		if (_name == null) {
			if (other._name != null)
				return false;
		} else if (!_name.equals(other._name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PathOfExileCharacter [_name=" + _name + ", _league=" + _league + ", _classId=" + _classId
				+ ", _ascendancyClass=" + _ascendancyClass + ", _classSpecificationName=" + _classSpecificationName
				+ ", _level=" + _level + "]";
	}
	

}

