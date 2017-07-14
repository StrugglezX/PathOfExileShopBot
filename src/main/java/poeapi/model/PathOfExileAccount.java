package poeapi.model;

import java.util.List;

public class PathOfExileAccount {
	private List<PathOfExileLeague> _leagues;
	private String _accountName;
	private String _poeSessId;

	public PathOfExileAccount(){
		super();
	}
	public PathOfExileAccount(List<PathOfExileLeague> leagues, String accountName, String poeSessId) {
		super();
		_leagues = leagues;
		_accountName = accountName;
		_poeSessId = poeSessId;
	}

	public List<PathOfExileLeague> getLeagues() {
		return _leagues;
	}

	public void setLeagues(List<PathOfExileLeague> leagues) {
		_leagues = leagues;
	}

	public String getAccountName() {
		return _accountName;
	}

	public void setAccountName(String accountName) {
		_accountName = accountName;
	}

	public String getPoeSessId() {
		return _poeSessId;
	}

	public void setPoeSessId(String poeSessId) {
		_poeSessId = poeSessId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_accountName == null) ? 0 : _accountName.hashCode());
		result = prime * result + ((_leagues == null) ? 0 : _leagues.hashCode());
		result = prime * result + ((_poeSessId == null) ? 0 : _poeSessId.hashCode());
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
		PathOfExileAccount other = (PathOfExileAccount) obj;
		if (_accountName == null) {
			if (other._accountName != null)
				return false;
		} else if (!_accountName.equals(other._accountName))
			return false;
		if (_leagues == null) {
			if (other._leagues != null)
				return false;
		} else if (!_leagues.equals(other._leagues))
			return false;
		if (_poeSessId == null) {
			if (other._poeSessId != null)
				return false;
		} else if (!_poeSessId.equals(other._poeSessId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PathOfExileAccount [_leagues=" + _leagues + ", _accountName=" + _accountName + ", _poeSessId="
				+ _poeSessId + "]";
	}
	
	
	
}
