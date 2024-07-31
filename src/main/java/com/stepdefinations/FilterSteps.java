package com.stepdefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.mns.keyword.UiKeyWords;
import com.mns.util.OR;
import com.mns.util.WaitFor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterSteps {
	@Given("Chrome browser is launched")
	public void Chrome_browser_is_launched() {
		UiKeyWords.openBrowser("Chrome");
		UiKeyWords.browserMaximize();
	}

	@Given("url is fully opened")
	public void url_is_fully_opened() {
		UiKeyWords.launchAppUrl("qa");

	}

	@When("user searches levis in search component")
	public void user_searches_levis_in_search_component() {
		UiKeyWords.enterText(OR.getLocator("homepage.searchbar"), "levis" + Keys.ENTER);
	}

	@When("apply men filter on search result page")
	public void apply_men_filter_on_search_result_page() {
		WaitFor.elementToBeClikable(OR.getLocator("filter.men"));
		UiKeyWords.clikOnElement(OR.getLocator("filter.men"));
	}

	@Then("veryfy that all results belongs to men")
	public void veryfy_that_all_results_belongs_to_men() {
		List<String> productDescriptions = UiKeyWords.getTexts("//h4[@class=\"product-product\"]");
		for (String productdescription : productDescriptions) {
			String prouductDescription = "";
			Assert.assertTrue(prouductDescription.contains("Men"));
		}
	}
	@When("user searches pollo in search component")
	public void user_searches_pollo_in_search_component() {
		UiKeyWords.enterText(OR.getLocator("homepage.searchbar"), "Pollo" + Keys.ENTER);
	}

	@When("apply discount filter of  percente")
	public void apply_discount_filter_of_percente() {
		UiKeyWords.clikOnElement(OR.getLocator("discountAndAbove.fiftypersent"));
		WaitFor.elementToBeClikable(OR.getLocator("discountAndAbove.fiftypersent"));
	}

	@Then("verify that all results")
	public void verify_that_all_results() {
		By driver = null;
		List<WebElement> productnames = driver.findElements((SearchContext) By.xpath("#\\32 3286674 > a > div.product-productMetaInfo > div.product-price > span.product-discountPercentage"));
		for (WebElement productname : productnames) {
			if (productname.getText().contains("(50%OFF)")) {
				System.out.println("Pass");
			} else {
				System.out.println("Fail");
			}
			Assert.assertTrue(true);
		}
	   
	}

	
}
