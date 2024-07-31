package com.mns.util;

public class Environment {
	private static final String filePath = System.getProperty("user.dir") + "/src/main/resources/com.mns.environment.properties";

	public static String getBrowserName(String browsername) {
		return getenvproperty(browsername);
	}

	public static String getAppUrl(String env) {
		return getenvproperty("app." + env + "url");

	}

	private static String getenvproperty(String property) {
		FileUtility util = new FileUtility();
		String browserName = util.readProperty(filePath, "property");
		return browserName;
	}

}
