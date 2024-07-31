package com.mns.keyword;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.mns.exceptions.InvalidBrowserNameException;
import com.mns.util.FileUtility;
import com.mns.util.WaitFor;

public class UiKeyWords {
	public static RemoteWebDriver driver;

	/**
	 * use this keyword to launch a new browser window
	 * 
	 * @param browsername is the name of the launch throws in
	 *                    InvalidBrowserNameException
	 */
	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else {
			throw new InvalidBrowserNameException(browserName);
		}
	}

	public static void browserMaximize() {
		driver.manage().window().maximize();
	}

	/**
	 * use this keyword to launch app url. Application url is mentioned in
	 * {@code"src\\main\\resources\\com.mns.environment.properties"}
	 * 
	 * @param env
	 */
	public static void launchBrowser(String browsername) {
		driver.get(browsername);
	}

	public static void launchAppUrl(String env) {
		FileUtility fileutil = new FileUtility();
		String baseDir = System.getProperty("user.dir");
		String url = fileutil.readProperty(baseDir + "/src/main/resources/com.mns.environment.properties",
				"app." + env + ".url");// qa
		System.out.println("URL: " + url);
		driver.get(url);
	}

	/**
	 * This method is no longer in use. Instead you can consider
	 * {@code clikOnElement(WebElement element)}. This method will be remove from
	 * upcoming version of framework.
	 * 
	 * @param element
	 */
	@Deprecated
	public static void clikOnElement(WebElement element) {
		element.click();
	}

	public static void clikOnElement(String locator) {
		driver.findElement(By.xpath(locator)).click();

	}

	public static void enterText(String locator, String text) {
		driver.findElement(By.xpath(locator)).sendKeys(text);
	}

	public static List<String> getTexts(String locator) {// for multiple
		List<WebElement> items = driver.findElements(By.xpath(locator));
		List<String> itemTexts = new ArrayList<String>();
		for (WebElement item : items) {
			itemTexts.add(item.getText());
		}
		return itemTexts;
	}

	public static String getText(String locator) {// fo single
		return driver.findElement(By.xpath(locator)).getText();
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void quitBrowser() {
		driver.quit();

	}

}
