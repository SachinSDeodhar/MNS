package com.project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParameterizedTastCaseDemo {
	RemoteWebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();

	}

	@Test
	public void verifyListOfProductWhenMenFilterIsAppliedForLevis() {

		driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\"]")).sendKeys("Levis" + Keys.ENTER);
		By menfilter = By.xpath("(//label[contains(@class,'gender')]/parent::li)[1]/label");
		wait.until(ExpectedConditions.elementToBeClickable(menfilter)).click();
		List<WebElement> productdDescriptions = driver.findElements(By.xpath("//h4[@class=\"product-product\"]"));
		wait.until(ExpectedConditions.stalenessOf((WebElement) productdDescriptions));
		for (WebElement DesctriptionMen : productdDescriptions) {
			String productdescription = "";
			if (DesctriptionMen.getText().contains("Men")) {
				System.out.println("Pass");
			} else {
				System.out.println("Fail");
			}
		}

	}

	@Test
	public void verifyPriseRangForLevisProducts() {
		driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\"]")).sendKeys("Levis" + Keys.ENTER);
		driver.executeScript("window.scrollBy(0,900)");
		driver.findElement(By.xpath("//input[@class=\"price-input\"][1]")).click();
		List<WebElement> pricesElement = driver.findElements(By.xpath("//span[@class=\"product-discountedPrice\"]"));
		By menfilter = By.xpath("//label[contains(@class,'gender')]/parent::li[1]/label");
		wait.until(ExpectedConditions.elementToBeClickable(menfilter)).click();
		List<Integer> prices = new ArrayList<Integer>();
		for (WebElement priceElement : pricesElement) {
			String price = priceElement.getText();
			Pattern p = Pattern.compile("\\d+");
			Matcher m = p.matcher(price);
			int priceInNum = 0;
			while (m.matches()) {
				priceInNum = Integer.parseInt(m.group());
			}
			prices.add(priceInNum);
		}
		for (int price: prices) {
			Assert.assertTrue(price>=159 && price>=2745);
				
			}
			
		}

	}

