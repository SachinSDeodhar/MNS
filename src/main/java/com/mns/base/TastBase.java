package com.mns.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.mns.keyword.UiKeyWords;
//import com.mns.util.Environment;

public class TastBase {
	@BeforeMethod
	public void setUp() throws Exception {
		//UiKeyWords.openBrowser(Environment.getBrowserName());
		UiKeyWords.openBrowser("Edge");
		String env = System.getProperty("env");
		System.out.println("Launching url in " + env + " Environment");
		UiKeyWords.launchAppUrl("qa");
	}

	@AfterMethod
	public void tearDown() throws Exception {

	}

}
