package com.revature.models;


public class ORMModel{
	
	private static String connectionURL;
	private static String ConnectionUN;
	private static String ConnectionPW;
	private static String driverName;
	
	
	public ORMModel() {
		super();
	}


	public static String getConnectionURL() {
		return connectionURL;
	}
	public static void setConnectionURL(String connectionURL) {
		ORMModel.connectionURL = connectionURL;
	}
	public static String getConnectionUN() {
		return ConnectionUN;
	}
	public static void setConnectionUN(String connectionUN) {
		ORMModel.ConnectionUN = connectionUN;
	}
	public static String getConnectionPW() {
		return ConnectionPW;
	}
	public static void setConnectionPW(String connectionPW) {
		ORMModel.ConnectionPW = connectionPW;
	}
	public static String getDriverName() {
		return driverName;
	}
	public static void setDriverName(String driverName) {
		ORMModel.driverName = driverName;
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
	
	
	
	
	
	
	
	

}
