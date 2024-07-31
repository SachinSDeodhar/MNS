package com.mns.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.mns.keyword.UiKeyWords;

public class WaitFor {
	public static FluentWait<WebDriver>wait;
	static {
	wait=new FluentWait<WebDriver>(UiKeyWords.driver);
	wait.withTimeout(Duration.ofSeconds(60));
	wait.pollingEvery(Duration.ofMillis(500));
	wait.ignoring(org.openqa.selenium.NoSuchElementException.class,ElementClickInterceptedException.class);
		
	}
	public static void elementToBeClikable(String locator) {
		By element=By.xpath(locator);
		
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
}
