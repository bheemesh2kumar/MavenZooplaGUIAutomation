package com.zoopla.regressiontests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zoopla.pagerepository.ZooplaLoginpage;
import com.zoopla.pagerepository.Zooplahomepage;

public class ZooplaHousePriceshowmuchismyhomeworthTest extends BaseTest {

	@Test
	public void forsalehyperlinkvalidaation() {

		Zooplahomepageref.mouseoverele(driver, Zooplahomepageref.housepricesheadermenu);

		if (Zooplahomepageref.howmuchismyhomeworthdropdownele.isDisplayed()) {
			System.out.println("howmuchismyhomeworthdropdownele is displayed successfully");
			Zooplahomepageref.howmuchismyhomeworthdropdownele.click();
		}

	}

	@Test
	public void housepriceshyperlinkvalidattion() {

		Zooplahomepageref.mouseoverele(driver, Zooplahomepageref.housepricesheadermenu);

		Zooplahomepageref.howmuchismyhomeworthdropdownele.click();
		ZooplahowmuchismyhomeworthpageORref.housepriceshyperlink.click();

		System.out.println(driver.getTitle());

		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Sold House Prices - Get historic data only on Zoopla"));

		ZooplahowmuchismyhomeworthpageORref.getregiondetails(ZooplahowmuchismyhomeworthpageORref.Browsehousepricestable,
				351959);

	}

}
