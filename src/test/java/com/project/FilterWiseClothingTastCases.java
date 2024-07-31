package com.project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class FilterWiseClothingTastCases {
	@Test
	public static void verfyMenTshirApplingFilterColorAndBrnadObserve() {
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
		driver.get("https://www.myntra.com/");
		
		driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\"]"))
				.sendKeys("allen-solly-T shirt" + Keys.ENTER);
		By menbutton = (By.xpath("(//label[contains(@class,'gender')]/parent::li[1]/label"));
		wait.until(ExpectedConditions.presenceOfElementLocated(menbutton)).click();
		WebElement whitecolor = driver.findElement(By.xpath("//span[@data-colorhex=\"white\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(whitecolor)).click();
	}

	@Test
	public static void verfyMenTshirApplingFilterdiscountAndAboveByBrandOfPollo() {
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
		driver.get("https://www.myntra.com/");
		
		driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\"]"))
				.sendKeys("Pollo Tshirt Men" + "" + Keys.ENTER);
		By discountAndAbove = (By.xpath("//*[@id=\"mountRoot\"]/div/main/div[3]/div[1]/section/div/div[5]/ul/li[1]"));
		wait.until(ExpectedConditions.presenceOfElementLocated(discountAndAbove)).click();
		List<WebElement> productnames = driver.findElements(By.xpath("//*[@id=\"23286674\"]/a/div[2]/div[1]/span[2]"));
		for (WebElement productname : productnames) {
			if (productname.getText().contains("(50%OFF)")) {
				System.out.println("Pass");
			} else {
				System.out.println("Fail");
			}
		}

	}

}
