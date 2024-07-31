package com.mns;

import java.util.List;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;

import com.mns.base.TastBase;
import com.mns.keyword.UiKeyWords;
import com.mns.util.OR;
import com.mns.util.WaitFor;

public class FilterTasteCases extends TastBase {
	@Test
	public static void verfyMenTshirApplingFilterColorAndObserve() {
		UiKeyWords.enterText(OR.getLocator("homepage.searchbar"), "Levis" + Keys.ENTER);
		WaitFor.elementToBeClikable(OR.getLocator("filter.men"));
		UiKeyWords.clikOnElement(OR.getLocator("filter.men"));
		System.out.println("Product descriptions locator: " + OR.getLocator("products.descriptions"));
		List<String> productDescriptions = UiKeyWords.getTexts(OR.getLocator("products.descriptions"));
		for (String productdescription : productDescriptions) {
			String prouductDescription = "";
			Assert.assertTrue(prouductDescription.contains("Men"));

		}
	}

}
