package com.stepdefinations;

import static org.testng.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.mns.keyword.UiKeyWords;
import com.mns.util.OR;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchBoxSteps {
	@Given("Edge browser is launch")
	public void edge_browser_is_launch() {
		UiKeyWords.openBrowser("Edge");
		UiKeyWords.browserMaximize();
	}

	@Given("Url is open")
	public void url_is_open() {
		UiKeyWords.launchAppUrl("dev");
	}

	@When("User searches lives women to in search component")
	public void user_searches_lives_women_to_in_search_component() {
		UiKeyWords.enterText(OR.getLocator("homepage.searchbar"), "Lives Women Top" + Keys.ENTER);
	}

	@Then("Verify that all result belongs to women")
	public void verify_that_all_result_belongs_to_women() {
		List<String> productDescriptions = UiKeyWords
				.getTexts("#\\3724360 > a > div.product-productMetaInfo > h4.product-product");
		for (String productdescription : productDescriptions) {
			String prouductDescription = "";
			Assert.assertTrue(prouductDescription.contains("Top"));
		}
	}

	@When("user click on magnifire")
	public void user_click_on_magnifire() {
		UiKeyWords.clikOnElement(OR.getLocator("search.magnifire"));

	}

	@Then("user should be able to click on the search magnifier")
	public void user_should_be_able_to_click_on_the_search_magnifier() {
		By searchMagnifier = By.cssSelector(OR.getLocator("search.magnifire"));
		((WebElement) searchMagnifier).click();
		assertTrue(((WebElement) searchMagnifier).isDisplayed());
		assertTrue(((WebElement) searchMagnifier).isEnabled());

	}

	@When("user enter the food keyword")
	public void user_enter_the_food_keyword() {
		UiKeyWords.enterText(OR.getLocator("homepage.searchbar"), "dahi" + Keys.ENTER);

	}

	@Then("suggetion is correct or not")
	public void suggetion_is_correct_or_not() {
		By driver = null;
		WebElement searchBar = driver.findElement((SearchContext) By.xpath(OR.getLocator("homepage.dropdownlist")));
		searchBar.sendKeys("chay" + Keys.ENTER);
		WebElement dropdown = driver.findElement((SearchContext) By.xpath("dropdownlist"));
		Assert.assertTrue(dropdown.isDisplayed());

	}
	
}
