package com.zoopla.regressiontests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zoopla.pagerepository.ZooplaLoginpage;
import com.zoopla.pagerepository.Zooplahomepage;

public class ZooplaForSaleTest extends BaseTest {

	@Test
	public void forsalehyperlinkvalidaation() {

		ExtentTestref = ExtentReportsref.createTest("forsalehyperlinkvalidaation");

		Assert.assertTrue(Zooplahomepageref.forsalehyperlik.isDisplayed());
		System.out.println("User is logged into zoopla home page successfully");
		logger.info("forsalehyperlink validated successfully");

	}

	@Test
	public void ukpropertyforsalepagevalidation() {
		ExtentTestref = ExtentReportsref.createTest("ukpropertyforsalepagevalidation");

		Zooplahomepageref.mouseoverele(driver, Zooplahomepageref.forsalehyperlik);

		Zooplahomepageref.UkProeprtiesforsaledropdown.click();
		logger.info("forsalehyperlink clicked successfully");

		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Houses and Flats for Sale | Property to Buy - Zoopla"));

	}

	@Test
	public void propertiesforsalesearch() {
		
		ExtentTestref = ExtentReportsref.createTest("propertiesforsalesearch");

		Zooplahomepageref.mouseoverele(driver, Zooplahomepageref.forsalehyperlik);

		Zooplahomepageref.UkProeprtiesforsaledropdown.click();
		logger.info("forsalehyperlink clicked successfully");

		UKPropertiesforsalepageref.ukpropertysaleinputbox.sendKeys("par");

		List<WebElement> propertysuggestionsvalues = UKPropertiesforsalepageref.ukpropertysalesuggestions;

		for (WebElement ele : propertysuggestionsvalues) {
			System.out.println(ele.getText());

			if (ele.getText().equals("Par, Cornwall")) {
				ele.click();
			}

		}

		UKPropertiesforsalepageref.selectdropdownval(UKPropertiesforsalepageref.ukpropertysaleminpricedropdown,
				"£10,000");
		UKPropertiesforsalepageref.selectdropdownval(UKPropertiesforsalepageref.ukpropertysalemaxpricedropdown,
				"£20,000");

		UKPropertiesforsalepageref.ukpropertysalesearchbutton.click();

		logger.info("user is provided all searched options and navigated to search pane successfully");

	}

}
