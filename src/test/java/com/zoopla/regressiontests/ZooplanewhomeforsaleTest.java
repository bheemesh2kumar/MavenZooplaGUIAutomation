package com.zoopla.regressiontests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ZooplanewhomeforsaleTest extends BaseTest {

	@Test
	public void validatenewhomesforsalepagetitle() {

		ExtentTestref = ExtentReportsref.createTest("validatenewhomesforsalepagetitle");

		Zooplahomepageref.mouseoverele(driver, Zooplahomepageref.forsalehyperlik);

		Zooplahomepageref.Uknewhomeforsaledropdown.click();

		System.out.println(driver.getTitle());

		Assert.assertTrue(
				driver.getTitle().equalsIgnoreCase("New Homes for Sale | Buy New Build Houses and Flats - Zoopla"));

	}

	@Test
	public void validatenewhomesforsalepageadvancefilters() throws InterruptedException {
		ExtentTestref = ExtentReportsref.createTest("validatenewhomesforsalepageadvancefilters");
		Zooplahomepageref.mouseoverele(driver, Zooplahomepageref.forsalehyperlik);

		Zooplahomepageref.Uknewhomeforsaledropdown.click();
		UKPropertiesforsalepageref.ukpropertysaleinputbox.sendKeys("tower");
		UKNewHomesforSalepageref.selectvaluefromsuggestons(UKPropertiesforsalepageref.ukpropertysalesuggestions,
				"Tower Cross, Devon");
		
		UKNewHomesforSalepageref.scrollintoview(driver, UKNewHomesforSalepageref.advanceserachbutton);

		UKNewHomesforSalepageref.advanceserachbutton.click();
	
		Thread.sleep(5000);

		UKNewHomesforSalepageref.scrollintoview(driver, UKNewHomesforSalepageref.distancefromlocationdropdownele);

		UKNewHomesforSalepageref.selectdropdownval(UKNewHomesforSalepageref.distancefromlocationdropdownele,
				"Within 30 miles");
		UKNewHomesforSalepageref.selectdropdownval(UKNewHomesforSalepageref.addeddropdownele, "Last 30 days");
		UKNewHomesforSalepageref.selectdropdownval(UKNewHomesforSalepageref.sortbydropdownele, "Most popular");
		UKPropertiesforsalepageref.ukpropertysalesearchbutton.click();

	}

}
