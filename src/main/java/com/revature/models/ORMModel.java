package com.revature.models;

import com.revature.utils.ConnectionUtil;

public class ORMModel extends ConnectionUtil{
	
	private String connectionURL;
	private String ConnectionUN;
	private String ConnectionPW;
	private String driverName;
	
	
	
	public ORMModel(String connectionURL, String connectionUN, String connectionPW, String driverName) {
		super();
		this.connectionURL = connectionURL;
		ConnectionUN = connectionUN;
		ConnectionPW = connectionPW;
		this.driverName = driverName;
	}
	
	
	public ORMModel() {
		super();
	}


	public String getConnectionURL() {
		return connectionURL;
	}
	public void setConnectionURL(String connectionURL) {
		this.connectionURL = connectionURL;
	}
	public String getConnectionUN() {
		return ConnectionUN;
	}
	public void setConnectionUN(String connectionUN) {
		ConnectionUN = connectionUN;
	}
	public String getConnectionPW() {
		return ConnectionPW;
	}
	public void setConnectionPW(String connectionPW) {
		ConnectionPW = connectionPW;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	@Override
	public String toString() {
		return "ORMModel [connectionURL=" + connectionURL + ", ConnectionUN=" + ConnectionUN + ", ConnectionPW="
				+ ConnectionPW + ", driverName=" + driverName + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ConnectionPW == null) ? 0 : ConnectionPW.hashCode());
		result = prime * result + ((ConnectionUN == null) ? 0 : ConnectionUN.hashCode());
		result = prime * result + ((connectionURL == null) ? 0 : connectionURL.hashCode());
		result = prime * result + ((driverName == null) ? 0 : driverName.hashCode());
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
		ORMModel other = (ORMModel) obj;
		if (ConnectionPW == null) {
			if (other.ConnectionPW != null)
				return false;
		} else if (!ConnectionPW.equals(other.ConnectionPW))
			return false;
		if (ConnectionUN == null) {
			if (other.ConnectionUN != null)
				return false;
		} else if (!ConnectionUN.equals(other.ConnectionUN))
			return false;
		if (connectionURL == null) {
			if (other.connectionURL != null)
				return false;
		} else if (!connectionURL.equals(other.connectionURL))
			return false;
		if (driverName == null) {
			if (other.driverName != null)
				return false;
		} else if (!driverName.equals(other.driverName))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	

}
